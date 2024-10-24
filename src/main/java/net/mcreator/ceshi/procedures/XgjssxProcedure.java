package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class XgjssxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		Xgjssx0Procedure.execute(world, x, y, z, entity);
		a = entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE) ? _livingEntity0.getAttribute(Attributes.ATTACK_DAMAGE).getBaseValue() : 0;
		entity.getPersistentData().putDouble("zdsmz", a);
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.ATTACK_DAMAGE))
			_livingEntity3.getAttribute(Attributes.ATTACK_DAMAGE)
					.setBaseValue((a + a * ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.JISHENG) ? _livEnt.getEffect(PrimogemcraftModMobEffects.JISHENG).getAmplifier() : 0) + 1) * 0.5));
	}
}
