package net.hackermdch.pgc.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;

import java.util.List;

public class WishDisplay extends BasicDisplay {
    public WishDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public static BasicDisplay.Serializer<WishDisplay> serializer() {
        return Serializer.ofSimpleRecipeLess(WishDisplay::new);
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PGCPlugin.WISH;
    }
}
