package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.hackermdch.pgc.StardustConverterRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;

import static net.mcreator.ceshi.init.PrimogemcraftModItems.SHANBIANZHICHEN;

public class ConvertDisplay implements Display {
    private final List<EntryIngredient> inputs, output;
    public final int cost;

    public ConvertDisplay(RecipeHolder<StardustConverterRecipe> recipe) {
        var data = recipe.value().get();
        inputs = ImmutableList.of(EntryIngredients.of(SHANBIANZHICHEN), EntryIngredients.of(data.input()), EntryIngredients.of(data.output()));
        output = ImmutableList.of(EntryIngredients.of(data.output()), EntryIngredients.of(data.input()));
        cost = data.cost();
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        return inputs;
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return output;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PGCPlugin.CONVERT;
    }
}
