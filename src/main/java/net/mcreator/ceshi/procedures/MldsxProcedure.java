package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class MldsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_03.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MLXDML_02.get().defaultBlockState(), 3);
			}
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_02.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MLXDML_01.get().defaultBlockState(), 3);
			}
			if (blockstate.getBlock() == PrimogemcraftModBlocks.MLXDML_01.get()) {
				world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.MOLADUI_02.get().defaultBlockState(), 3);
			}
		}
	}
}
