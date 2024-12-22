package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Difficulty;

public class ShitishengchengProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (world.getDifficulty() == Difficulty.PEACEFUL) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}
