package net.hackermdch;

import com.google.common.collect.ImmutableSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;

import java.util.Set;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID)
class CustomEvents {
    private static Set<Item> items;

    @SubscribeEvent
    protected static void onItemToss(ItemTossEvent event) {
        if (items == null)
            items = CustomUtils.enableInventoryAttribute.stream().map(s -> BuiltInRegistries.ITEM.getHolder(ResourceLocation.parse(s)).orElseThrow().value()).collect(ImmutableSet.toImmutableSet());
        if (!items.contains(event.getEntity().getItem().getItem())) return;
        event.getEntity().getItem().getAttributeModifiers().modifiers().forEach(m -> {
            if (m.slot() == EquipmentSlotGroup.ANY) {
                var attr = event.getPlayer().getAttributes();
                if (attr.hasModifier(m.attribute(), m.modifier().id())) {
                    var ins = attr.getInstance(m.attribute());
                    assert ins != null;
                    ins.removeModifier(m.modifier());
                }
            }
        });
    }
}
