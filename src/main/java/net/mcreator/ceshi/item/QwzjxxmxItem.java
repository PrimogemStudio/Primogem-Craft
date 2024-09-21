
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwzjxxmxItem extends Item {
	public QwzjxxmxItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u6E6E\u706D\u70DB\u526A\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A76\u6316\u6398\u65F6\u6839\u636E\u65B9\u5757\u786C\u5EA6\u5C06\u6709\u4E0D\u540C\u6982\u7387"));
		list.add(Component.literal("\u00A76\u6389\u843D\u5B87\u5B99\u788E\u7247"));
	}
}
