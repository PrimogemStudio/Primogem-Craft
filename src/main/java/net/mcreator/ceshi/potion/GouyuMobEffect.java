
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.GouyukaishiProcedure;
import net.mcreator.ceshi.procedures.Gouyu_shuxingProcedure;

public class GouyuMobEffect extends MobEffect {
	public GouyuMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1878800);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		GouyukaishiProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Gouyu_shuxingProcedure.execute(entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
