
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class XingjidaletouItem extends Item {
	public XingjidaletouItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7d\u624B\u6301\u7834\u574F\u65B9\u5757\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77 - \u5C0F\u6982\u7387\u4E3A\u526F\u624B\u53EF\u9644\u9B54\u7269\u54C1"));
		list.add(Component.literal("\u00A77 \u6DFB\u52A0\u4E00\u4E2A\u00A7f1~20\u7EA7\u00A77\u7684\u968F\u673A\u9644\u9B54"));
		list.add(Component.literal("\u00A77 - \u4F46\u4E5F\u6709\u5C0F\u6982\u7387\u635F\u574F\u5947\u7269\uFF0C\u5E76"));
		list.add(Component.literal("\u00A77 \u6E05\u9664\u73A9\u5BB6\u00A7c\u6240\u6709\u7ECF\u9A8C\u503C\uFF01"));
	}
}
