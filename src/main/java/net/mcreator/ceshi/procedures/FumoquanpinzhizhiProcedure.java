package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class FumoquanpinzhizhiProcedure {
	public static double execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getDouble("shijianbuchang");
	}
}
