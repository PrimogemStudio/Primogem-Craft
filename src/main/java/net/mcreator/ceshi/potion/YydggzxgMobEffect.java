
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.YdggzxgsxProcedure;
import net.mcreator.ceshi.procedures.Ydggzxgsx0Procedure;

public class YydggzxgMobEffect extends MobEffect {
	public YydggzxgMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.primogemcraft.yydggzxg";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		Ydggzxgsx0Procedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		YdggzxgsxProcedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
