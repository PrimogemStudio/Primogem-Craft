package net.hackermdch.pgc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.function.Supplier;

import static net.hackermdch.pgc.CustomRegister.RECIPE_SERIALIZERS;

public final class StardustConverterRecipe implements Recipe<RecipeInput> {
    private static final Supplier<RecipeSerializer<?>> STARDUST_CONVERTER = RECIPE_SERIALIZERS.register("stardust_converter", Serializer::new);
    private final ItemStack first;
    private final ItemStack second;
    private final int cost;

    public record Data(ItemStack input, ItemStack output, int cost) {
    }

    private StardustConverterRecipe(ItemStack first, ItemStack second, int cost) {
        this.first = first;
        this.second = second;
        this.cost = cost;
    }

    public static void register() {
    }

    public Data match(ItemStack item) {
        if (ItemStack.isSameItemSameComponents(first, item) && item.getCount() >= first.getCount()) {
            return new Data(first.copy(), second.copy(), cost);
        } else if (ItemStack.isSameItemSameComponents(second, item) && item.getCount() >= second.getCount()) {
            return new Data(second.copy(), first.copy(), cost);
        }
        return null;
    }

    public Data get() {
        return new Data(first.copy(), second.copy(), cost);
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        return false;
    }

    @Override
    public ItemStack assemble(RecipeInput recipeInput, HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return false;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return ItemStack.EMPTY;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return STARDUST_CONVERTER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return CustomRegister.STARDUST_CONVERTER.get();
    }

    private static class Serializer implements RecipeSerializer<StardustConverterRecipe> {
        private static final MapCodec<StardustConverterRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                ItemStack.STRICT_CODEC.fieldOf("first").forGetter(recipe -> recipe.first),
                ItemStack.STRICT_CODEC.fieldOf("second").forGetter(recipe -> recipe.second),
                Codec.INT.fieldOf("cost").forGetter(recipe -> recipe.cost)
        ).apply(instance, StardustConverterRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, StardustConverterRecipe> STREAM_CODEC = StreamCodec.of(Serializer::encode, Serializer::decode);

        @Override
        public MapCodec<StardustConverterRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, StardustConverterRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static StardustConverterRecipe decode(RegistryFriendlyByteBuf buffer) {
            return new StardustConverterRecipe(ItemStack.STREAM_CODEC.decode(buffer), ItemStack.STREAM_CODEC.decode(buffer), buffer.readInt());
        }

        private static void encode(RegistryFriendlyByteBuf buffer, StardustConverterRecipe recipe) {
            ItemStack.STREAM_CODEC.encode(buffer, recipe.first);
            ItemStack.STREAM_CODEC.encode(buffer, recipe.second);
            buffer.writeInt(recipe.cost);
        }
    }
}
