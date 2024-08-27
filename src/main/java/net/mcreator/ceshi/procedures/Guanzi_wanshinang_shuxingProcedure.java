package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class Guanzi_wanshinang_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (blockstate.getBlock() == PrimogemcraftModBlocks.DAGUANZI.get()) {
				if (entity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(PrimogemcraftModItems.WANSHINANG.get())) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)) && !(entity instanceof LivingEntity _livEnt5 && _livEnt5.hasEffect(MobEffects.DIG_SLOWDOWN))) {
						entity.getPersistentData().putBoolean("wanshinang_naijiu", true);
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(PrimogemcraftModItems.WANSHINANG.get(), 1);
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"loot spawn ~ ~ ~ loot primogemcraft:blocks/daguanzi");
					}
				}
			}
			if (blockstate.getBlock() == PrimogemcraftModBlocks.XIAOGUANZI.get()) {
				if (entity instanceof Player _plrCldCheck11 && _plrCldCheck11.getCooldowns().isOnCooldown(PrimogemcraftModItems.WANSHINANG.get())) {
					if (!(new Object() {
						public boolean checkGamemode(Entity _ent) {
							if (_ent instanceof ServerPlayer _serverPlayer) {
								return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
							} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
								return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
										&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
							}
							return false;
						}
					}.checkGamemode(entity)) && !(entity instanceof LivingEntity _livEnt13 && _livEnt13.hasEffect(MobEffects.DIG_SLOWDOWN))) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"loot spawn ~ ~ ~ loot primogemcraft:blocks/xiaoguanzi");
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(PrimogemcraftModItems.WANSHINANG.get(), 1);
						entity.getPersistentData().putBoolean("wanshinang_naijiu", true);
					}
				}
			}
		}
	}
}
