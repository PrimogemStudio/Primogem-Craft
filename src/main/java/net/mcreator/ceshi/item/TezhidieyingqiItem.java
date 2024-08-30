
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class TezhidieyingqiItem extends Item {
	public TezhidieyingqiItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u611F\u6069\u6234\u5FB7\u5427\uFF01\u6211\u90FD\u66FF\u4F60\u8003\u8651\u597D\u4E86\uFF01"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7d\u9AD8\u9636\u5F3A\u5316\u6750\u6599"));
	}
}
