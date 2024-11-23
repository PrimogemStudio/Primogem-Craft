package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;

import static net.hackermdch.pgc.rei.PGCClientPlugin.WISH;

public class WishDisplay extends BasicDisplay {
    final EntityType<? extends LivingEntity> entityType;

    public WishDisplay(EntityType<? extends LivingEntity> type, TagKey<Item> tag) {
        super(ImmutableList.of(), ImmutableList.of(EntryIngredients.ofItemTag(tag)));
        entityType = type;
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return WISH;
    }
}
