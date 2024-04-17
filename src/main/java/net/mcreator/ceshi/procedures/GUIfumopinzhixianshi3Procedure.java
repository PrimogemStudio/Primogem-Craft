package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;

public class GUIfumopinzhixianshi3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") == 4;
	}
}
