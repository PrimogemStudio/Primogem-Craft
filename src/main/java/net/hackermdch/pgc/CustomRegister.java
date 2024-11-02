package net.hackermdch.pgc;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class CustomRegister {
    public static final DeferredRegister<LootItemConditionType> LOOT_CONDITION_TYPES = DeferredRegister.create(Registries.LOOT_CONDITION_TYPE, MODID);
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENT_TYPES = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, MODID);
    public static final Supplier<LootItemConditionType> IS_CHEST = LOOT_CONDITION_TYPES.register("is_chest", () -> new LootItemConditionType(IsChestCondition.CODEC));

    static {
        DATA_COMPONENT_TYPES.register("custom_bar", () -> CustomComponents.CUSTOM_BAR);
    }

    public static void register(IEventBus modBus) {
        LOOT_CONDITION_TYPES.register(modBus);
        DATA_COMPONENT_TYPES.register(modBus);
    }
}
