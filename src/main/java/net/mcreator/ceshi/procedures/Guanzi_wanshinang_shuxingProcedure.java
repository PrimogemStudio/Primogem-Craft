package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Guanzi_wanshinang_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			entity.getPersistentData().putBoolean("guan_zi_po_huai", true);
			PrimogemcraftMod.queueServerWork(1, () -> {
				entity.getPersistentData().putBoolean("guan_zi_po_huai", false);
			});
			entity.getPersistentData().putDouble("guan_zi_x", x);
			entity.getPersistentData().putDouble("guan_zi_y", y);
			entity.getPersistentData().putDouble("guan_zi_z", z);
			if (blockstate.getBlock() == PrimogemcraftModBlocks.XIAOGUANZI.get()) {
				entity.getPersistentData().putBoolean("xiao_guan_zi", true);
			} else {
				entity.getPersistentData().putBoolean("xiao_guan_zi", false);
			}
		}
	}
}
