package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class JcsxcxsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (itemstack.getItem() == PrimogemcraftModItems.JIJIUCHANZHIYUAN.get()) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u5F53\u524D\u7948\u613F\u52A0\u6210;"), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A78\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d"
							+ new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5) + "%")), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A78\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76"
							+ new java.text.DecimalFormat("##.##").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10) + "%")), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A76\u5F53\u524D\u7948\u613F\u52A0\u6210;"), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A78\u6BCF\u4E2A\u51FA\u7D2B\u6982\u7387\u589E\u52A0:\u00A7d"
							+ new java.text.DecimalFormat("##.##").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 5) / 10) + "%")), false);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A78\u6BCF\u4E2A\u51FA\u91D1\u6982\u7387\u589E\u52A0:\u00A76"
							+ new java.text.DecimalFormat("##.##").format((itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Prayers_strengthen") / 10) / 10) + "%")), false);
			}
		}
	}
}
