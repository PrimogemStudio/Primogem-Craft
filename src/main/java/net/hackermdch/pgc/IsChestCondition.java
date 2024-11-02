package net.hackermdch.pgc;

import com.mojang.serialization.MapCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import org.jetbrains.annotations.NotNull;

import static net.hackermdch.pgc.CustomRegister.IS_CHEST;
import static net.minecraft.core.registries.Registries.LOOT_TABLE;

public class IsChestCondition implements LootItemCondition {
    static final MapCodec<IsChestCondition> CODEC = MapCodec.unit(new IsChestCondition());

    @Override
    @NotNull
    public LootItemConditionType getType() {
        return IS_CHEST.get();
    }

    @Override
    public boolean test(LootContext context) {
        return context.getResolver().lookupOrThrow(LOOT_TABLE).getOrThrow(ResourceKey.create(LOOT_TABLE, context.getQueriedLootTableId())).value().getParamSet() == LootContextParamSets.CHEST;
    }
}
