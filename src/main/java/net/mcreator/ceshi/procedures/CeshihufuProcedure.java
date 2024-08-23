package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;

public class CeshihufuProcedure {
	public static void execute(ItemStack itemstack) {
		itemstack.getOrCreateTag().putDouble("sanyuezhufu", (itemstack.getOrCreateTag().getDouble("sanyuezhufu") + 1));
		if (itemstack.getOrCreateTag().getDouble("sanyuezhufu") >= 24000) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			itemstack.getOrCreateTag().putDouble("sanyuezhufu", 0);
		}
	}
}
