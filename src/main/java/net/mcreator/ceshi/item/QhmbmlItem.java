
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class QhmbmlItem extends Item {
	public QhmbmlItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u6469\u62C9\u6750\u8D28\u5347\u7EA7"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u53EF\u5E94\u7528\u4E8E\uFF1A"));
		list.add(Component.literal("\u00A79 \u5251\u6216\u5DE5\u5177"));
		list.add(Component.literal("\u00A77\u6240\u9700\u539F\u6750\u6599\uFF1A"));
		list.add(Component.literal("\u00A79 \u6469\u62C9"));
	}
}
