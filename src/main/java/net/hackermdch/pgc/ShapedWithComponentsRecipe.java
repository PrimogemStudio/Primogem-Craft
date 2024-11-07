package net.hackermdch.pgc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static net.hackermdch.pgc.CustomRegister.RECIPE_SERIALIZERS;

public final class ShapedWithComponentsRecipe implements CraftingRecipe {
    private static final Supplier<RecipeSerializer<?>> CRAFTING_SHAPED_WITH_COMPONENTS = RECIPE_SERIALIZERS.register("crafting_shaped_with_components", Serializer::new);
    private final ShapedRecipePattern pattern;
    private final ItemStack result;
    private final Item source;
    private final String group;
    private final CraftingBookCategory category;
    private final boolean showNotification;

    public ShapedWithComponentsRecipe(String group, CraftingBookCategory category, ShapedRecipePattern pattern, ItemStack result, Item source, boolean showNotification) {
        this.group = group;
        this.category = category;
        this.pattern = pattern;
        this.result = result;
        this.source = source;
        this.showNotification = showNotification;
    }

    @Override
    public boolean matches(@NotNull CraftingInput input, @NotNull Level level) {
        return pattern.matches(input);
    }

    @Override
    @NotNull
    public ItemStack assemble(@NotNull CraftingInput inv, @NotNull HolderLookup.Provider registries) {
        var result = getResultItem(registries).copy();
        for (var it : inv.items()) {
            if (it.is(source)) {
                var com = result.get(CustomComponents.CUSTOM_BAR);
                result.applyComponents(it.getComponents());
                var bar = result.get(CustomComponents.CUSTOM_BAR);
                if (bar != null) {
                    bar = new CustomBar(bar.numerator, com != null ? com.denominator : bar.denominator, bar.visible);
                    result.set(CustomComponents.CUSTOM_BAR, bar);
                }
                return result;
            }
        }
        return result;
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return width >= pattern.width() && height >= pattern.height();
    }

    @Override
    @NotNull
    public String getGroup() {
        return group;
    }

    @Override
    public boolean showNotification() {
        return showNotification;
    }

    @Override
    @NotNull
    public ItemStack getResultItem(@NotNull HolderLookup.Provider registries) {
        return result;
    }

    @Override
    @NotNull
    public NonNullList<Ingredient> getIngredients() {
        return pattern.ingredients();
    }

    @Override
    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return CRAFTING_SHAPED_WITH_COMPONENTS.get();
    }

    @Override
    @NotNull
    public CraftingBookCategory category() {
        return category;
    }

    @Override
    public boolean isIncomplete() {
        var ingredients = getIngredients();
        return ingredients.isEmpty() || ingredients.stream().filter(it -> !it.isEmpty()).anyMatch(Ingredient::hasNoItems);
    }

    private static class Serializer implements RecipeSerializer<ShapedWithComponentsRecipe> {
        private static final MapCodec<ShapedWithComponentsRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.optionalFieldOf("group", "").forGetter(recipe -> recipe.group), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(recipe -> recipe.category), ShapedRecipePattern.MAP_CODEC.forGetter(recipe -> recipe.pattern), ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result), BuiltInRegistries.ITEM.byNameCodec().fieldOf("source").validate(item -> item == Items.AIR ? DataResult.error(() -> "Item must not be minecraft:air") : DataResult.success(item)).forGetter(recipe -> recipe.source), Codec.BOOL.optionalFieldOf("show_notification", true).forGetter(recipe -> recipe.showNotification)).apply(instance, ShapedWithComponentsRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, ShapedWithComponentsRecipe> STREAM_CODEC = StreamCodec.of(Serializer::encode, Serializer::decode);
        private static final StreamCodec<RegistryFriendlyByteBuf, Holder<Item>> ITEM_STREAM_CODEC = ByteBufCodecs.holderRegistry(Registries.ITEM);

        @Override
        @NotNull
        public MapCodec<ShapedWithComponentsRecipe> codec() {
            return CODEC;
        }

        @Override
        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, ShapedWithComponentsRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ShapedWithComponentsRecipe decode(RegistryFriendlyByteBuf buffer) {
            var group = buffer.readUtf();
            var category = buffer.readEnum(CraftingBookCategory.class);
            var pattern = ShapedRecipePattern.STREAM_CODEC.decode(buffer);
            var result = ItemStack.STREAM_CODEC.decode(buffer);
            var source = ITEM_STREAM_CODEC.decode(buffer);
            var showNotification = buffer.readBoolean();
            return new ShapedWithComponentsRecipe(group, category, pattern, result, source.value(), showNotification);
        }

        private static void encode(RegistryFriendlyByteBuf buffer, ShapedWithComponentsRecipe recipe) {
            buffer.writeUtf(recipe.group);
            buffer.writeEnum(recipe.category);
            ShapedRecipePattern.STREAM_CODEC.encode(buffer, recipe.pattern);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            ITEM_STREAM_CODEC.encode(buffer, BuiltInRegistries.ITEM.wrapAsHolder(recipe.source));
            buffer.writeBoolean(recipe.showNotification);
        }
    }
}