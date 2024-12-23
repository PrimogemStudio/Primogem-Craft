
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.ZLetouchengfahenshuxingProcedure;

public class LetoudechengfaMobEffect extends MobEffect {
	public LetoudechengfaMobEffect() {
		super(MobEffectCategory.NEUTRAL, -39169);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		ZLetouchengfahenshuxingProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}
