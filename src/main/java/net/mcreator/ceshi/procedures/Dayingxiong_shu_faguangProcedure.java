package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class Dayingxiong_shu_faguangProcedure {
	public static boolean execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return false;
		return itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("jingyanshu_naijiu")
				&& (itemstack.getDamageValue() == 0 && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(itemstack) : false) || itemstack.getDamageValue() == 0);
	}
}
