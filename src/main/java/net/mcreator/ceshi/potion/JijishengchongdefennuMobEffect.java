
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.InstantenousMobEffect;

import net.mcreator.ceshi.procedures.Jijishengdefennu01Procedure;

public class JijishengchongdefennuMobEffect extends InstantenousMobEffect {
	public JijishengchongdefennuMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -2943466);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Jijishengdefennu01Procedure.execute(entity.level(), entity);
		return super.applyEffectTick(entity, amplifier);
	}
}
