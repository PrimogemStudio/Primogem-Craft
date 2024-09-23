
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwyhjbItem extends Item {
	public QwyhjbItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u00A7b\u00A7l\u94F6\u6CB3\u5927\u4E50\u900F\u00A7r\u00A76\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7e\u635F\u574F\u6982\u7387\u4EC5\u4E3A10%\uFF0C\u4E14\u4E0D\u4F1A\u6D88\u8017\u9971\u98DF\u5EA6"));
		list.add(Component.literal("\u00A7e\u63D0\u4F9B\u7684\u5956\u54C1\u8D28\u91CF\u5927\u5927\u964D\u4F4E"));
	}
}
