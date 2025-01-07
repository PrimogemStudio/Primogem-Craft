package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		WuqidengjiHSProcedure.execute(world, entity, entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, 30, Mth.nextInt(RandomSource.create(), 1, 100));
		DiaoyongwuqijinglianHSProcedure.execute(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY, Mth.nextInt(RandomSource.create(), 1, 2));
	}
}
