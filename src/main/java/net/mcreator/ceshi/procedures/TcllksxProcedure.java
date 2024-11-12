package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class TcllksxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		double a = 0;
		double b = 0;
		double a1 = 0;
		double a2 = 0;
		double c = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
		b = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		if (a > 1 || b > 0) {
			itemstack.shrink(1);
			DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.TEZHIDIEYINGQI.get()), b);
			a1 = 30;
			a2 = 60;
			if (a > a2) {
				c = a - a2;
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLMO.get()), c);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLLIANG.get()), 30);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), 29);
			} else if (a >= a1 && a <= a2) {
				c = a - a1;
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLLIANG.get()), c);
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), 29);
			} else if (a < a1 && a > 1) {
				DiaoyongwupindiaoluoProcedure.execute(world, x, y, z, new ItemStack(PrimogemcraftModItems.JLZA.get()), a - 1);
			}
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.destroy")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.destroy")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		}
	}
}
