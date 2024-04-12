
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Smcl_zf_sx_1Procedure;
import net.mcreator.ceshi.procedures.Smcl_zf_sx_0Procedure;

public class SmclzfMobEffect extends MobEffect {
	public SmclzfMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Smcl_zf_sx_1Procedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Smcl_zf_sx_0Procedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
