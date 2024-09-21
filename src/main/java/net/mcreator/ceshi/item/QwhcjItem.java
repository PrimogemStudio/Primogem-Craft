
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwhcjItem extends Item {
	public QwhcjItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7c\u00A7l\u5408\u6210\u5947\u7269\u4F7F\u7528"));
		list.add(Component.literal("\u00A75\u53EF\u5C06\u4E24\u4E2A\u540C\u7EA7\u522B\u5947\u7269\u5408\u6210"));
		list.add(Component.literal("\u00A75\u4E3A\u66F4\u9AD8\u7EA7\u522B\u968F\u673A\u5947\u7269"));
	}
}
