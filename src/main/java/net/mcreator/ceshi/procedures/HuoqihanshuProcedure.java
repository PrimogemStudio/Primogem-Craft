package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

public class HuoqihanshuProcedure {
	public static void execute(Entity entity, ItemStack huoqi, ItemStack itemstack, String zhi) {
		if (entity == null || zhi == null)
			return;
		double a = 0;
		String b = "";
		a = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(huoqi) : false) ? 0.5 : 0;
		b = zhi;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaotie")))) {
			{
				final String _tagName = b;
				final double _tagValue = (0.5 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaozuanshi")))) {
			{
				final String _tagName = b;
				final double _tagValue = (1 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaoxiajiehejin")))) {
			{
				final String _tagName = b;
				final double _tagValue = (2 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
