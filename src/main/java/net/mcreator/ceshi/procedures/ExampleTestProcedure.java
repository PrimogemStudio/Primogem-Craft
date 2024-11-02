package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class ExampleTestProcedure {
	public static void execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		CustomAPI.getCustomBar(stack).numerator++;
	}
}
