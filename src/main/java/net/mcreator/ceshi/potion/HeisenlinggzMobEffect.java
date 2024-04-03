
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Heisenlin_ggz_xiaoguo_sx_1Procedure;
import net.mcreator.ceshi.procedures.Heisenlin_ggz_xiaoguo_sx_0Procedure;

public class HeisenlinggzMobEffect extends MobEffect {
	public HeisenlinggzMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10066330);
	}

	@Override
	public String getDescriptionId() {
		return "effect.primogemcraft.heisenlinggz";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Heisenlin_ggz_xiaoguo_sx_0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Heisenlin_ggz_xiaoguo_sx_1Procedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
