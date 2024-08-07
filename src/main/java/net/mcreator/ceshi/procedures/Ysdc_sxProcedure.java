package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

public class Ysdc_sxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u73A9\u5BB6<" + entity.getDisplayName().getString() + ">\u7684\u62BD\u5361\u8BB0\u5F55\uFF1A")), false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u84DD\u00A7b"
					+ new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan) + "\u00A77\u603B\u5171")),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A77\u5F53\u524D\u51FA\u7D2B\u00A7d"
							+ new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi) + "\u00A77\u603B\u5171")),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u91D1\u00A7e"
					+ new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin) + "\u00A77\u603B\u5171")),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A77\u8DDD\u79BB\u51FA\u7D2B\u00A7a\u8FD8\u5269\u00A77"
							+ new java.text.DecimalFormat("##.##").format(10 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi) + "\u00A7a\u62BD")),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A77\u8DDD\u79BB\u51FA\u91D1\u00A7a\u8FD8\u5269\u00A77"
							+ new java.text.DecimalFormat("##.##").format(50 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi) + "\u00A7a\u62BD")),
					false);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(
					Component.literal(("\u00A7e\u5E73\u5747\u6BCF"
							+ new java.text.DecimalFormat("##.##").format(((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin
									+ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi
									+ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan)
									/ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin)
							+ "\u53D1\u51FA\u73B0\u00A7b1\u4E2A\u00A7e\u91D1\u5149\uFF01")),
					false);
	}
}
