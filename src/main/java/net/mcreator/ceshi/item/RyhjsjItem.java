
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class RyhjsjItem extends Item {
	public RyhjsjItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u53EF\u5728\u953B\u9020\u53F0\u5347\u7EA7\u4E0B\u754C\u5408\u91D1\u8D28\u88C5\u5907"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u53EF\u5E94\u7528\u4E8E\uFF1A"));
		list.add(Component.literal("\u00A79 \u4E0B\u754C\u5408\u91D1\u5251"));
		list.add(Component.literal("\u00A79 \u4E0B\u754C\u5408\u91D1\u5236\u76D4\u7532"));
	}
}
