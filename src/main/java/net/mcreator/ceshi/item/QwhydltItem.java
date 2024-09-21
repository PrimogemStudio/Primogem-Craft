
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwhydltItem extends Item {
	public QwhydltItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7c\u00A7l\u6CE8\u610F\uFF01\u672C\u5947\u7269\u6548\u679C\u89E6\u53D1\u540E\u4E0D\u53EF\u9006"));
		list.add(Component.literal("\u00A75\u526F\u624B\u6301\u6709\u7834\u574F\u65B9\u5757\u65F6\uFF1A"));
		list.add(Component.literal("\u00A7c\u5FC5\u5B9A\u6467\u6BC1\u8BE5\u5947\u7269\u5E76\u5220\u9664\u73A9\u5BB6\u7684"));
		list.add(Component.literal("\u00A7c\u00A7l\u6240\u6709\u6570\u636E\uFF01\u00A7r\u00A7c\u662F\u7684\uFF0C\u662F\u6240\u6709\uFF01\uFF01"));
		list.add(Component.literal("\u00A7c\u00A7k123\u00A7r\u00A7c\u4F60\u6562\u8BD5\u8BD5\u5417\uFF1F\u00A7c\u00A7k123"));
	}
}
