package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class SsanbamiantouxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack mu_biao, ItemStack shuchu_2, boolean qw_0, boolean zhan_li_pin, double beilv, double lengque, String zhiling) {
		if (entity == null || zhiling == null)
			return;
		HSsbmtsxProcedure.execute(world, x, y, z, entity, item, mu_biao, shuchu_2, qw_0, zhan_li_pin, beilv, lengque, zhiling);
	}
}
