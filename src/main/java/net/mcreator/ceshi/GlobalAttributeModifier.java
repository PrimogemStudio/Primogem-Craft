package net.mcreator.ceshi;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.minecraft.world.entity.EquipmentSlotGroup.*;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.*;
import static net.minecraft.world.entity.ai.attributes.Attributes.*;

@EventBusSubscriber(modid = MODID)
public class GlobalAttributeModifier {
    private static final Map<ResourceLocation, Consumer<ItemAttributeModifierEvent>> modifiers = getModifiers();

    private static void init(Map<String, Consumer<ItemAttributeModifierEvent>> modifiers) {
        modifiers.put("primogemcraft:ljtg_02", e -> {
            e.replaceModifier(ARMOR_TOUGHNESS, modifier("ljta", 2, ADD_VALUE), HAND);
        });
        modifiers.put("primogemcraft:xzcfyxwzd", e -> {
            e.replaceModifier(ARMOR_TOUGHNESS, modifier("ljtb", 2, ADD_VALUE), HAND);
        });
    }

    private static AttributeModifier modifier(String id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(ResourceLocation.parse(id), amount, operation);
    }

    private static Map<ResourceLocation, Consumer<ItemAttributeModifierEvent>> getModifiers() {
        var modifiers = new HashMap<String, Consumer<ItemAttributeModifierEvent>>();
        init(modifiers);
        return modifiers.entrySet().stream().collect(ImmutableMap.toImmutableMap(e -> ResourceLocation.parse(e.getKey()), Map.Entry::getValue));
    }

    @SubscribeEvent
    protected static void onEvent(ItemAttributeModifierEvent event) {
        var con = modifiers.get(BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem()));
        if (con == null) return;
        con.accept(event);
    }
}
