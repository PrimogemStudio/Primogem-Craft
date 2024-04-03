package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Szqsx2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getOrCreateTag().getBoolean("shengzhangqiao_geiguole")) {
			if (Math.random() < ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQCAO.get())) : false) ? 0.015 : 0.01)) {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PrimogemcraftModBlocks.CAOYUANSUECI.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					PrimogemcraftMod.queueServerWork(2, () -> {
						world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.CAOYUANSUECI.get().defaultBlockState(), 3);
					});
				}
			}
		} else {
			PrimogemcraftMod.queueServerWork(2, () -> {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.CAOYUANSUECI.get().defaultBlockState(), 3);
			});
			itemstack.getOrCreateTag().putBoolean("shengzhangqiao_geiguole", true);
		}
	}
}
