
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class LaoshiItem extends Item {
	public LaoshiItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u534E\u4E3D\u7684\u77F3\u5934\uFF0C\u4F3C\u4E4E\u6CA1\u4EC0\u4E48\u7528"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7d\u73CD\u60DC\u6750\u6599"));
	}
}
