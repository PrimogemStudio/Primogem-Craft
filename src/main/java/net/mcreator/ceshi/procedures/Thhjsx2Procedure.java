package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class Thhjsx2Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("true") && !(new Object() {
				public boolean checkGamemode(Entity _ent) {
					if (_ent instanceof ServerPlayer _serverPlayer) {
						return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
					} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
						return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null
								&& Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
					}
					return false;
				}
			}.checkGamemode(entity))) {
				{
					final String _tagName = "true";
					final double _tagValue = (Mth.nextInt(RandomSource.create(), 1, 4));
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("true") == 2) {
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A75\u00A7l\u300E\u5947\u7269\u300F\u00A7f\u5929\u5F57\u5408\u91D1 I \u578B"));
				} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("true") == 3) {
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A75\u00A7l\u300E\u5947\u7269\u300F\u00A7f\u5929\u5F57\u5408\u91D1 II \u578B"));
				} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("true") > 3) {
					itemstack.set(DataComponents.CUSTOM_NAME, Component.literal("\u00A75\u00A7l\u300E\u5947\u7269\u300F\u00A7f\u5929\u5F57\u5408\u91D1 III \u578B"));
				}
			}
		}
	}
}