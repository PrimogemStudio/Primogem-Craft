package net.hackermdch.pgc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

import static net.hackermdch.pgc.CustomRegister.RECIPE_SERIALIZERS;

public class MaterialRecoveryRecipe extends ShapelessRecipe {
    private static final Supplier<RecipeSerializer<?>> CRAFTING_MATERIAL_RECOVERY = RECIPE_SERIALIZERS.register("crafting_material_recovery", Serializer::new);
    private static final TagKey<Item> tag = ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "wuqi"));
    private final ItemStack result;

    public static void register() {
    }

    public MaterialRecoveryRecipe(String group, CraftingBookCategory category, ItemStack result, NonNullList<Ingredient> ingredients) {
        super(group, category, result, ingredients);
        this.result = result;
    }

    @Override
    @NotNull
    public ItemStack assemble(@NotNull CraftingInput input, @NotNull HolderLookup.Provider registries) {
        var result = super.assemble(input, registries);
        for (var it : input.items()) {
            if (it.is(tag)) {
                var data = it.get(DataComponents.CUSTOM_DATA);
                if (data != null) {
                    result.set(DataComponents.CUSTOM_DATA, data);
                }
                return result;
            }
        }
        return result;
    }

    @Override
    @NotNull
    public RecipeSerializer<?> getSerializer() {
        return CRAFTING_MATERIAL_RECOVERY.get();
    }

    public static class Serializer implements RecipeSerializer<MaterialRecoveryRecipe> {
        private static final MapCodec<MaterialRecoveryRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(Codec.STRING.optionalFieldOf("group", "").forGetter(ShapelessRecipe::getGroup), CraftingBookCategory.CODEC.fieldOf("category").orElse(CraftingBookCategory.MISC).forGetter(ShapelessRecipe::category), ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result), Ingredient.CODEC_NONEMPTY.listOf().fieldOf("ingredients").flatXmap(ingredients -> {
            Ingredient[] aingredient = ingredients.toArray(Ingredient[]::new); // Neo skip the empty check and immediately create the array.
            if (aingredient.length == 0) {
                return DataResult.error(() -> "No ingredients for shapeless recipe");
            } else {
                return aingredient.length > ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth() ? DataResult.error(() -> "Too many ingredients for shapeless recipe. The maximum is: %s".formatted(ShapedRecipePattern.getMaxHeight() * ShapedRecipePattern.getMaxWidth())) : DataResult.success(NonNullList.of(Ingredient.EMPTY, aingredient));
            }
        }, DataResult::success).forGetter(ShapelessRecipe::getIngredients)).apply(instance, MaterialRecoveryRecipe::new));
        public static final StreamCodec<RegistryFriendlyByteBuf, MaterialRecoveryRecipe> STREAM_CODEC = StreamCodec.of(Serializer::toNetwork, Serializer::fromNetwork);

        @Override
        @NotNull
        public MapCodec<MaterialRecoveryRecipe> codec() {
            return CODEC;
        }

        @Override
        @NotNull
        public StreamCodec<RegistryFriendlyByteBuf, MaterialRecoveryRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static MaterialRecoveryRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            var group = buffer.readUtf();
            var category = buffer.readEnum(CraftingBookCategory.class);
            int i = buffer.readVarInt();
            var ingredients = NonNullList.withSize(i, Ingredient.EMPTY);
            ingredients.replaceAll(p_319735_ -> Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            var result = ItemStack.STREAM_CODEC.decode(buffer);
            return new MaterialRecoveryRecipe(group, category, result, ingredients);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, MaterialRecoveryRecipe recipe) {
            buffer.writeUtf(recipe.getGroup());
            buffer.writeEnum(recipe.category());
            buffer.writeVarInt(recipe.getIngredients().size());
            for (var ingredient : recipe.getIngredients()) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }
            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
        }
    }
}
