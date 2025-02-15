package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class BhmgsxProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getBoolean("bhmg");
	}
}
