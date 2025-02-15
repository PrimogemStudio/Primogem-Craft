package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

public class GUIbhmgfqProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		GUIqingchu012Procedure.execute(entity);
		if (entity instanceof Player _player)
			_player.closeContainer();
		QycjzlpProcedure.execute(world, x, y, z);
	}
}
