package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;

public class Wqzhg_sx_0Procedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		if (!world.isClientSide()) {
			itemstack.setDamageValue((int) (itemstack.getDamageValue() - 0.5 * HSjinglianProcedure.execute(itemstack)));
		}
	}
}
