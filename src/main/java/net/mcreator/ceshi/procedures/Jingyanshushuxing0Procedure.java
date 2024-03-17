package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class Jingyanshushuxing0Procedure {
	public static boolean execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		return !itemstack.getOrCreateTag().getBoolean((entity.getDisplayName().getString()));
	}
}
