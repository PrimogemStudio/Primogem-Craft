
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class GongsideguguzhongItem extends Item {
	public GongsideguguzhongItem() {
		super(new Item.Properties().durability(2233).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return 1;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u62FE\u53D6\u8BE5\u5947\u7269\u540E\u79FB\u96642.5%~75%\u7684"));
		list.add(Component.literal("\u00A7e\u5F53\u524D\u7ECF\u9A8C\u503C\uFF01"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u53EF\u5408\u6210\u4FEE\u590D\u540E\u91CD\u590D\u4F7F\u7528"));
		list.add(Component.literal("\u00A78\u4E00\u4E2A\u6361\u5230\u5C31\u4F1A\u88AB\u538B\u69A8\u7684\u516C\u53F8\u7684\u5495\u5495\u949F"));
	}
}
