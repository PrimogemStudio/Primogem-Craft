
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class ChunmeizhipaoItem extends Item {
	public ChunmeizhipaoItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u6BCF\u62E5\u670964\u5B87\u5B99\u788E\u7247\uFF0C\u653B\u51FB\u76EE\u6807\u540E\u4F1A\u5BF9"));
		list.add(Component.literal("\u00A77\u5176\u989D\u5916\u9020\u6210\u4E00\u6B21\u7B49\u540C\u4E8E\u653B\u51FB\u8005\u6700\u5927\u751F\u547D"));
		list.add(Component.literal("\u00A771.6%\u7684\u989D\u5916\u4F24\u5BB3"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7d\u8BE5\u6548\u679C\u81F3\u591A2\u79D2\u89E6\u53D1\u4E00\u6B21"));
	}
}
