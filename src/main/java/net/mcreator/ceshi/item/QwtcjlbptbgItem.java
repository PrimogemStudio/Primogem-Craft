
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwtcjlbptbgItem extends Item {
	public QwtcjlbptbgItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u62FE\u53D6\u7ECF\u9A8C\u7403\u7684\u6536\u76CA\u63D0\u5347100%"));
		list.add(Component.literal("\u00A77\u4F46\u4E5F\u4F1A\u4EE58\u70B9\u7ECF\u9A8C\u503C\u6BCF\u4E2A\u7684\u6BD4\u4F8B\u56DE\u6536\u5B87"));
		list.add(Component.literal("\u00A77\u5B99\u788E\u7247\uFF0C\u56DE\u6536576\u4E2A\u540E\u6539\u5947\u7269\u5C06\u88AB\u9500\u6BC1"));
		list.add(Component.literal("\u00A77\u5947\u7269\u88AB\u9500\u6BC1\u540E\u6263\u966450%\u5F53\u524D\u7ECF\u9A8C\u503C"));
	}
}
