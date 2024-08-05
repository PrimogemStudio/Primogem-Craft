package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class Ysrq_sx_0Procedure {
	public static void execute(LevelAccessor world, ItemStack itemstack) {
		double a = 0;
		if (!(world.isClientSide() && itemstack.getOrCreateTag().getBoolean("qidong"))) {
			a = Mth.nextInt(RandomSource.create(), 1, 6);
			if (a == 1) {
				itemstack.getOrCreateTag().putDouble("feng", 1);
			}
			if (a == 2) {
				itemstack.getOrCreateTag().putDouble("yan", 1);
			}
			if (a == 3) {
				itemstack.getOrCreateTag().putDouble("lei", 1);
			}
			if (a == 4) {
				itemstack.getOrCreateTag().putDouble("cao", 1);
			}
			if (a == 5) {
				itemstack.getOrCreateTag().putDouble("shui", 1);
			}
			if (a == 6) {
				itemstack.getOrCreateTag().putDouble("huo", 1);
			}
			itemstack.getOrCreateTag().putBoolean("qidong", true);
		}
	}
}
