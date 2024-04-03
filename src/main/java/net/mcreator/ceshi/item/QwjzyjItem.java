
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwjzyjItem extends Item {
	public QwjzyjItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u6BCF\u62E5\u6709\u4E00\u4E2A\u5DF2\u635F\u574F\u5947\u7269\uFF0C\u653B\u51FB\u76EE\u6807\u540E\u4F1A\u5BF9\u5176\u989D\u5916"));
		list.add(Component.literal("\u00A77\u9020\u6210\u4E00\u6B21\u7B49\u540C\u4E8E\u81EA\u8EAB\u6700\u5927\u751F\u547D0.3%\u7684\u989D\u5916\u4F24\u5BB3"));
		list.add(Component.literal("\u00A77\u81F3\u591A\u4EE5\u8FD9\u79CD\u65B9\u5F0F\u9020\u6210\u989D\u5916300%\u81EA\u8EAB\u6700\u5927\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77\u7684\u989D\u5916\u4F24\u5BB3\uFF01"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7d\u8BE5\u6548\u679C\u6BCF\u79D2\u81F3\u591A\u89E6\u53D1\u4E00\u6B21"));
	}
}
