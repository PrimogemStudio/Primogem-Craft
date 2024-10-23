package net.mcreator.ceshi;

import com.google.common.collect.ImmutableMap;
import net.hackermdch.CustomUtils.AttributeModifierEventWrapper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ItemAttributeModifierEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import static net.hackermdch.CustomUtils.enableForInventory;
import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.minecraft.world.entity.EquipmentSlotGroup.*;
import static net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation.*;
import static net.minecraft.world.entity.ai.attributes.Attributes.*;

@EventBusSubscriber(modid = MODID)
public class GlobalAttributeModifier {
    private static final Map<ResourceLocation, Consumer<AttributeModifierEventWrapper>> modifiers = getModifiers();

    private static void init(Map<String, Consumer<AttributeModifierEventWrapper>> modifiers) {
        modifiers.put("primogemcraft:ljtg_02", e -> {
            e.set(ARMOR_TOUGHNESS, modifier("ljta", 1.5, ADD_VALUE), HAND);
        });
        modifiers.put("primogemcraft:xzcfyxwzd", e -> {
            e.set(ARMOR_TOUGHNESS, modifier("ljtb", 2, ADD_VALUE), HAND);
        });
        modifiers.put("primogemcraft:qwtldhy", e -> {
            e.set(MOVEMENT_SPEED, modifier("tldhy", 0.05, ADD_VALUE), ANY);
            e.set(MOVEMENT_SPEED, modifier("tldhy", 0.05, ADD_VALUE));
        });
        enableForInventory("primogemcraft:qwtldhy");
    }

    private static void custom(AttributeModifierEventWrapper event) {
    }

    private static AttributeModifier modifier(String id, double amount, AttributeModifier.Operation operation) {
        return new AttributeModifier(ResourceLocation.parse(id), amount, operation);
    }

    private static Map<ResourceLocation, Consumer<AttributeModifierEventWrapper>> getModifiers() {
        var modifiers = new HashMap<String, Consumer<AttributeModifierEventWrapper>>();
        init(modifiers);
        return modifiers.entrySet().stream().collect(ImmutableMap.toImmutableMap(e -> ResourceLocation.parse(e.getKey()), Map.Entry::getValue));
    }

    public static void handle(AttributeModifierEventWrapper event) {
        modifiers.getOrDefault(BuiltInRegistries.ITEM.getKey(event.item.getItem()), GlobalAttributeModifier::custom).accept(event);
    }

    @SubscribeEvent
    static void onEvent(ItemAttributeModifierEvent event) {
        handle(new AttributeModifierEventWrapper(event::replaceModifier, event.getItemStack()));
    }
}
