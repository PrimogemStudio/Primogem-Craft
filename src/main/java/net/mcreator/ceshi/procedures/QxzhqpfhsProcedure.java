package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class QxzhqpfhsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack item_0, ItemStack item_1, double zhi, double zhi_0, double zhi_1) {
		QxzhqsxhsProcedure.execute(world, x, y, z, item_1, item_0, zhi, 1, zhi_0, zhi_1);
		QxzhqsxhsProcedure.execute(world, x, y, z, item_0, item_1, zhi, 3, zhi_1, zhi_0);
	}
}
