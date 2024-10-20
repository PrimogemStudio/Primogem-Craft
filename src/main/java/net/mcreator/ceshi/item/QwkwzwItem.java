
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwkwzwItem extends Item {
	public QwkwzwItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7a\u00A7l\u53EF\u4EE5\u4F7F\u7528\u5408\u6210\u6765\u4FEE\u590D\u4E00\u4E2A\u5947\u7269"));
		list.add(Component.literal("\u00A7a\u4E0E\u666E\u901A\u866B\u7F51\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u51FB\u6740\u751F\u7269\u540E50%\u6062\u590D10%\u6700\u5927\u751F"));
		list.add(Component.literal(" \u547D\u503C"));
		list.add(Component.literal("25%\u5BF9\u81EA\u8EAB\u989D\u5916\u9020\u6210\u4E00\u6B2120%\u6700"));
		list.add(Component.literal(" \u5927\u751F\u547D\u503C\u7684\u771F\u5B9E\u4F24\u5BB3"));
	}
}
