package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

import net.hackermdch.pgc.CustomAPI;

public class ExampleTooltipProcedure {
	public static String execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var bar = CustomAPI.getCustomBar(stack);
		return "\u8FDB\u5EA6\uFF1A" + bar.numerator + "/" + bar.denominator;
	}
}
