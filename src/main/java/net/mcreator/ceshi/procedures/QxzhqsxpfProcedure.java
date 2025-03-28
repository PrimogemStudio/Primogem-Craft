package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class QxzhqsxpfProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		boolean o1 = false;
		if (!ModList.get().isLoaded("genshincraft")) {
			QxzhqsxhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGHUI.get()), new ItemStack(PrimogemcraftModItems.XINGCHEN.get()), 1, 1, 2, 1);
			QxzhqsxhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGCHEN.get()), new ItemStack(PrimogemcraftModItems.XINGHUI.get()), 1, 3, 1, 2);
		} else {
			QxzhqsxhsProcedure.execute(world, x, y, z, new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("genshincraft:primogem"))), new ItemStack(PrimogemcraftModItems.YUANSHI.get()), 2, 1, 6, 1);
		}
	}
}
