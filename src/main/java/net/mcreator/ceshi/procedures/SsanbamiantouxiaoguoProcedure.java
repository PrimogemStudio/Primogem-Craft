package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class SsanbamiantouxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, double lengque) {
		if (entity == null)
			return;
		HSsbmtsxProcedure.execute(world, x, y, z, entity, lengque);
	}
}
