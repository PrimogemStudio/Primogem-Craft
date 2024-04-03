package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class BwdcqpzguangliangProcedure {
	public static boolean execute(ItemStack itemstack) {
		return itemstack.getOrCreateTag().getBoolean("bwd_yinhang");
	}
}
