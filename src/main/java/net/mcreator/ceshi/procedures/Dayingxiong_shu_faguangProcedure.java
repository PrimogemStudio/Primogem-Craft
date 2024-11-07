package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class Dayingxiong_shu_faguangProcedure {
	public static boolean execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var bar = CustomAPI.getCustomBar(stack);
		return bar.numerator == bar.denominator;
	}
}
