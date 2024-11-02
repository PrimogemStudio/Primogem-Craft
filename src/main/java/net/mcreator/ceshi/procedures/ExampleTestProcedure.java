package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class ExampleTestProcedure {
	public static void execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var bar = CustomAPI.getCustomBar(stack);
		if (bar.numerator > 10) {
			bar.numerator = 100;
		} else {
			bar.numerator += 2;
		}
	}
}
