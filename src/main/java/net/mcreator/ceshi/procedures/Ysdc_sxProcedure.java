package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

import java.util.Calendar;

public class Ysdc_sxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7d\u5DF2\u8BB0\u5F55\uFF0C\u53F3\u952E\u67E5\u770B"), false);
			itemstack.getOrCreateTag().putString("vhoukajiance_shijian", Calendar.getInstance().getTime().toString());
			itemstack.getOrCreateTag().putString("vhoukajiance_mingcheng", (entity.getDisplayName().getString()));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_lan", ((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_zi", ((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_jin", ((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_zi_1", (10 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_jin_1", (50 - (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi));
			itemstack.getOrCreateTag().putDouble("vhoukajiance_pinjun",
					(((entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin
							+ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi
							+ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan)
							/ (entity.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin));
			itemstack.setHoverName(Component.literal(("<" + entity.getDisplayName().getString() + ">\u5206\u4EAB\u7684\u7948\u613F\u8BB0\u5F55")));
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u73A9\u5BB6<" + itemstack.getOrCreateTag().getString("vhoukajiance_mingcheng") + ">\u7684\u62BD\u5361\u8BB0\u5F55\uFF1A")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u622A\u81F3\u7CFB\u7EDF\u65F6:" + itemstack.getOrCreateTag().getString("vhoukajiance_shijian") + "\u8BB0\u5F55")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u84DD\u00A7b" + itemstack.getOrCreateTag().getDouble("vhoukajiance_lan") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u7D2B\u00A7d" + itemstack.getOrCreateTag().getDouble("vhoukajiance_zi") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u5F53\u524D\u51FA\u91D1\u00A7e" + itemstack.getOrCreateTag().getDouble("vhoukajiance_jin") + "\u00A77\u603B\u5171")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u8DDD\u79BB\u51FA\u7D2B\u00A7a\u8FD8\u5269\u00A77" + itemstack.getOrCreateTag().getDouble("vhoukajiance_zi_1") + "\u00A7a\u62BD")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A77\u8DDD\u79BB\u51FA\u91D1\u00A7a\u8FD8\u5269\u00A77" + itemstack.getOrCreateTag().getDouble("vhoukajiance_jin_1") + "\u00A7a\u62BD")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(
						Component.literal(("\u00A7e\u5E73\u5747\u7EA6" + new java.text.DecimalFormat("").format(Math.round(itemstack.getOrCreateTag().getDouble("vhoukajiance_pinjun"))) + "\u53D1\u51FA\u73B0\u00A7b1\u4E2A\u00A7e\u91D1\u5149\uFF01")),
						false);
		}
	}
}
