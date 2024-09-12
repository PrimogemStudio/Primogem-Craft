package net.mcreator.ceshi;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class PGCEventHandler {
    static class AppendChestLootModifier extends LootModifier {
        static final Supplier<Codec<AppendChestLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(inst -> codecStart(inst).and(ResourceLocation.CODEC.fieldOf("id").forGetter(m -> m.id)).apply(inst, AppendChestLootModifier::new)));
        private final ResourceLocation id;

        private AppendChestLootModifier(LootItemCondition[] conditionsIn, ResourceLocation id) {
            super(conditionsIn);
            this.id = id;
        }

        @SuppressWarnings("deprecation")
        @Override
        @NotNull
        protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
            if (context.getResolver().getLootTable(context.getQueriedLootTableId()).getParamSet() != LootContextParamSets.CHEST)
                return generatedLoot;
            var lootTable = context.getLevel().getServer().getLootData().getLootTable(id);
            lootTable.getRandomItemsRaw(context, it -> {
                if (!it.isEmpty()) generatedLoot.add(it);
            });
            return generatedLoot;
        }

        @Override
        public Codec<? extends IGlobalLootModifier> codec() {
            return CODEC.get();
        }
    }

    static class PGCRegistries {
        static final DeferredRegister<LootItemFunctionType> LOOT_FUNCTIONS = DeferredRegister.create(Registries.LOOT_FUNCTION_TYPE, PrimogemcraftMod.MODID);
        static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, PrimogemcraftMod.MODID);

        static {
            LOOT_MODIFIER_SERIALIZERS.register("append_chest", AppendChestLootModifier.CODEC);
        }

        static void register(IEventBus eventBus) {
            LOOT_FUNCTIONS.register(eventBus);
            LOOT_MODIFIER_SERIALIZERS.register(eventBus);
        }
    }
}
