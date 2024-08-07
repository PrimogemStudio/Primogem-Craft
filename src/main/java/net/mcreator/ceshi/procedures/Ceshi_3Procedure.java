package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

public class Ceshi_3Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		if (entity.isShiftKeyDown()) {
			{
				double _setval = 0;
				entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.wj_ck_lan = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.wj_ck_zi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.wj_ck_jin = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.zi_baodi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.jin_baodi = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("\u5F53\u524D\u84DD" + new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan))),
						false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("\u5F53\u524D\u7D2B" + new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi))),
						false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(
						("\u5F53\u524D\u91D1" + new java.text.DecimalFormat("##.##").format((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin))),
						false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u8DDD\u79BB\u51FA\u7D2B"
						+ new java.text.DecimalFormat("##.##").format(10 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi))), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u8DDD\u79BB\u51FA\u91D1"
						+ new java.text.DecimalFormat("##.##").format(50 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi))), false);
		}
	}
}
