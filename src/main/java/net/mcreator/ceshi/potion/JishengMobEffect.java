
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

import net.mcreator.ceshi.procedures.JijishengxiaoguoProcedure;

public class JishengMobEffect extends InstantenousMobEffect {
	public JishengMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -4756225);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		JijishengxiaoguoProcedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
