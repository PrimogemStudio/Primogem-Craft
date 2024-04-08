
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Flggzxgsx1Procedure;
import net.mcreator.ceshi.procedures.Flggz_xg_0_sx_0Procedure;

public class Fzggzxg0MobEffect extends MobEffect {
	public Fzggzxg0MobEffect() {
		super(MobEffectCategory.HARMFUL, -26113);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Flggz_xg_0_sx_0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Flggzxgsx1Procedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
