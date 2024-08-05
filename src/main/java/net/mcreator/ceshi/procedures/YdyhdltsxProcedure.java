package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class YdyhdltsxProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("shuliang");
	}
}
