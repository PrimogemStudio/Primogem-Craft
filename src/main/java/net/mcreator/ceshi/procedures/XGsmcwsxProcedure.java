package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class XGsmcwsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double a = 0;
		XGsmcwsx0Procedure.execute(entity);
		a = entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity0.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0;
		entity.getPersistentData().putDouble("xg_smcw", a);
		if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MAX_HEALTH))
			_livingEntity3.getAttribute(Attributes.MAX_HEALTH)
					.setBaseValue((a - ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.X_GSMCW) ? _livEnt.getEffect(PrimogemcraftModMobEffects.X_GSMCW).getAmplifier() : 0) + 1) * 2));
	}
}
