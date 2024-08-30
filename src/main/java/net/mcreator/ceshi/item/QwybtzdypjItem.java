
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwybtzdypjItem extends Item {
	public QwybtzdypjItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7d\u5B58\u5728\u7269\u54C1\u680F\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77\u653B\u51FB\u76EE\u6807\u4F1A\u4F7F\u76EE\u6807\u5C0F\u8303\u56F4\u5185\u8840\u91CF\u5927\u4E8E80%\u7684"));
		list.add(Component.literal("\u00A77\u975E\u73A9\u5BB6\u751F\u7269\u53D7\u5230\u4E00\u6B21\u771F\u5B9E\u4F24\u5BB3\uFF0C\u4F24\u5BB3\u8303\u56F4"));
		list.add(Component.literal("\u00A77\u4E0D\u8D85\u8FC7\u8840\u91CF\u603B\u503C\u768420%"));
	}
}
