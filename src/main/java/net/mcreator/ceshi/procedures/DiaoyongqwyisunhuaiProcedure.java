package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class DiaoyongqwyisunhuaiProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("\u00A75\u300E\u5947\u7269\u300F" + itemstack.getDisplayName().getString() + "\u00A7c\u5DF2\u635F\u574F\uFF01")), false);
	}
}
