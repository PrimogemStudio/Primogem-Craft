package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class Buwending_cunquProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("bwd_yinhang");
	}
}
