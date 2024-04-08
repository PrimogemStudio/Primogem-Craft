
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Qhmbmlys01Item extends Item {
	public Qhmbmlys01Item() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u5143\u7D20\u6676\u4F53\u5347\u7EA7"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u53EF\u5E94\u7528\u4E8E\uFF1A"));
		list.add(Component.literal("\u00A79 \u76D4\u7532\u6216\u6B66\u5668"));
		list.add(Component.literal("\u00A77\u6240\u9700\u539F\u6750\u6599\uFF1A"));
		list.add(Component.literal("\u00A79 \u5143\u7D20\u6676\u4F53\u5F3A\u5316\u80DA"));
	}
}
