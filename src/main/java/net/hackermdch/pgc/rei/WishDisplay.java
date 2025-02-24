package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;

import java.util.List;

public class WishDisplay extends BasicDisplay {
    public final EntityType<? extends LivingEntity> entityType;

    public WishDisplay(EntityType<? extends LivingEntity> type, List<EntryIngredient> outputs) {
        super(ImmutableList.of(), outputs);
        entityType = type;
    }

    @SuppressWarnings("unchecked")
    public static BasicDisplay.Serializer<WishDisplay> serializer() {
        return Serializer.ofRecipeLess((input, output, tag) -> new WishDisplay((EntityType<? extends LivingEntity>) BuiltInRegistries.ENTITY_TYPE.get(ResourceLocation.parse(tag.getString("type"))), output), (display, tag) -> tag.putString("type", BuiltInRegistries.ENTITY_TYPE.getKey(display.entityType).toString()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return PGCPlugin.WISH;
    }
}
