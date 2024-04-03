package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

public class JljsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == PrimogemcraftModItems.JLJTIE.get()) {
			if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") < 4 && !(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.WEAKNESS))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 60, (int) (PrimogemcraftModVariables.genshincraft ? 1 : 0), false, false));
				itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") + 1));
				PrimogemcraftMod.queueServerWork(100, () -> {
					if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") > 0) {
						itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") - 1));
					}
				});
			}
		}
		if (itemstack.getItem() == PrimogemcraftModItems.JLJZS.get()) {
			if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") < 6 && !(entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.WEAKNESS))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 100, (int) (PrimogemcraftModVariables.genshincraft ? 2 : 0), false, false));
				itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") + 1));
				PrimogemcraftMod.queueServerWork(120, () -> {
					if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") > 0) {
						itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") - 1));
					}
				});
			}
		}
		if (itemstack.getItem() == PrimogemcraftModItems.JJLJXJHJ.get()) {
			if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") < 11 && !(entity instanceof LivingEntity _livEnt38 && _livEnt38.hasEffect(MobEffects.WEAKNESS))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, (int) (PrimogemcraftModVariables.genshincraft ? 4 : 1), false, false));
				itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") + 1));
				PrimogemcraftMod.queueServerWork(160, () -> {
					if (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") > 0) {
						itemstack.getOrCreateTag().putDouble("jl_j_sx_01", (itemstack.getOrCreateTag().getDouble("jl_j_sx_01") - 1));
					}
				});
			}
		}
	}
}
