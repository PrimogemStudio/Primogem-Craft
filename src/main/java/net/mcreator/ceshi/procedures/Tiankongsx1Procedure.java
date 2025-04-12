package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class Tiankongsx1Procedure {
	public static void execute(LevelAccessor world, DamageSource da, Entity entity, Entity sourceentity) {
		if (da == null || entity == null || sourceentity == null)
			return;
		double nd1 = 0;
		if (!world.isClientSide()) {
			nd1 = Mth.nextInt(RandomSource.create(), 1,
					(int) ((sourceentity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity1.getAttribute(Attributes.ATTACK_DAMAGE).getValue() : 0) * 1.5));
			entity.hurt(da, (float) nd1);
		}
	}
}
