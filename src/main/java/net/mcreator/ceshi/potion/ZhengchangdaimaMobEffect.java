
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Daima_xiaoguoProcedure;

public class ZhengchangdaimaMobEffect extends MobEffect {
	public ZhengchangdaimaMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
		return true;
	}

	@Override
	public boolean applyEffectTick(LivingEntity entity, int amplifier) {
		Daima_xiaoguoProcedure.execute();
		return super.applyEffectTick(entity, amplifier);
	}
}
