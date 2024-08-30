
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Qhmbmlys02Item extends Item {
	public Qhmbmlys02Item() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u5143\u7D20\u6676\u4F53\u5F3A\u5316"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A77\u53EF\u5E94\u7528\u4E8E\uFF1A"));
		list.add(Component.literal("\u00A79 \u539F\u77F3\u5DE5\u5177"));
		list.add(Component.literal("\u00A77\u6240\u9700\u539F\u6750\u6599\uFF1A"));
		list.add(Component.literal("\u00A79 \u5143\u7D20\u6676\u4F53"));
	}
}
