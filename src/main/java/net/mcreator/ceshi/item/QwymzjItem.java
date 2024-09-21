
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QwymzjItem extends Item {
	public QwymzjItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u7834\u574F\u65B9\u5757\u540E\u5C06\u83B7\u5F97\u968F\u673A"));
		list.add(Component.literal("\u00A77\u7B49\u7EA7 \u529B\u91CF I ~ IV \u6548\u679C"));
		list.add(Component.literal("\u00A78\u6301\u7EED\u65B9\u5757\u786C\u5EA6 * 5\u79D2"));
	}
}
