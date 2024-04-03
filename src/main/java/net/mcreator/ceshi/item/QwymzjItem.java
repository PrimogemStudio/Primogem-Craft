
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
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
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u7834\u574F\u65B9\u5757\u540E\u4F9D\u636E\u65B9\u5757\u786C\u5EA6\u63D0\u4F9B\u4E0D\u540C"));
		list.add(Component.literal("\u00A77\u65F6\u957F \u529B\u91CF I ~ IV \u6548\u679C"));
	}
}
