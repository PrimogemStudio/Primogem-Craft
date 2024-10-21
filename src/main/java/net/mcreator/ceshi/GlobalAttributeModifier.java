package net.mcreator.ceshi;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

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

    public static void init(Map<String, Consumer<ItemAttributeModifierEvent>> modifiers) {
        modifiers.put("stone", e -> {
            e.replaceModifier(MOVEMENT_SPEED, modifier("base_movement_speed", 0.1, ADD_VALUE), HAND);
            e.replaceModifier(MOVEMENT_SPEED, modifier("offhand_movement_speed", 0.04, ADD_VALUE), OFFHAND);
        });
        modifiers.put("dirt", e -> {
            e.replaceModifier(ATTACK_DAMAGE, modifier("base_attack_damage", 0.1, ADD_VALUE), HAND);
            e.replaceModifier(MOVEMENT_SPEED, modifier("base_movement_speed", 0.02, ADD_MULTIPLIED_BASE), HEAD);
        });
    }

    private static AttributeModifier modifier(String id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(ResourceLocation.parse(id), amount, operation);
    }

    private static Map<ResourceLocation, Consumer<ItemAttributeModifierEvent>> getModifiers() {
        var m = new HashMap<String, Consumer<ItemAttributeModifierEvent>>();
        var modifiers = new HashMap<ResourceLocation, Consumer<ItemAttributeModifierEvent>>();
        init(m);
        m.forEach((r, a) -> modifiers.put(ResourceLocation.tryParse(r), a));
        return modifiers;
    }

    @SubscribeEvent
    protected static void onEvent(ItemAttributeModifierEvent event) {
        var con = modifiers.get(BuiltInRegistries.ITEM.getKey(event.getItemStack().getItem()));
        if (con == null) return;
        con.accept(event);
    }
}
