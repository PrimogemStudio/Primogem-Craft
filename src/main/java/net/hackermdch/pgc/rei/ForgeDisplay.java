package net.hackermdch.pgc.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;

import java.util.List;

import static net.mcreator.ceshi.init.PrimogemcraftModItems.*;

public class ForgeDisplay implements Display {
    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(EntryIngredients.ofItems(List.of(JLZA, JLLIANG, JLMO, MYZJ, TEZHIDIEYINGQI, JHSB_0, JHSB_1, JHSB_2)), EntryIngredients.ofItemTag(ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "wuqi"))));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PGCPlugin.FORGE;
    }
}
