package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class JcsxcxsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A76\u5F53\u524D\u7948\u613F\u52A0\u6210;"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d" + itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 5 + "%")), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76" + itemstack.getOrCreateTag().getDouble("Prayers_strengthen") / 10 + "%")), false);
		}
	}
}
