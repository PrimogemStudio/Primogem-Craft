package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QxzhqsxpfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		QxzhqsxhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGHUI.get()), new ItemStack(PrimogemcraftModItems.XINGCHEN.get()), 1, 2, 1);
		QxzhqsxhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGCHEN.get()), new ItemStack(PrimogemcraftModItems.XINGHUI.get()), 3, 1, 2);
	}
}
