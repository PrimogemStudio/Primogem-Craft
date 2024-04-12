package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Smcl_zf_sx_0Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.getMobType() == MobType.UNDEAD) {
			PrimogemcraftMod.queueServerWork(1, () -> {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SMCLZF.get(), 80, 0, false, false));
			});
		}
	}
}
