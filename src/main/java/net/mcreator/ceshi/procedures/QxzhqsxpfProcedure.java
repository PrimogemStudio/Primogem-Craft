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
		QxzhqpfhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.XINGCHEN.get()), new ItemStack(PrimogemcraftModItems.XINGHUI.get()), 1, 2, 1);
		if (ModList.get().isLoaded("genshincraft")) {
			QxzhqpfhsProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.YUANSHI.get()), new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse("genshincraft:primogems"))), 2, 6, 1);
		}
	}
}
