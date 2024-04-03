
package net.mcreator.ceshi.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.ceshi.procedures.Flggzxgsx2Procedure;

public class Fzggzxg1MobEffect extends MobEffect {
	public Fzggzxg1MobEffect() {
		super(MobEffectCategory.HARMFUL, -39169);
	}

	@Override
	public String getDescriptionId() {
		return "effect.primogemcraft.fzggzxg_1";
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		Flggzxgsx2Procedure.execute(entity.level(), entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
