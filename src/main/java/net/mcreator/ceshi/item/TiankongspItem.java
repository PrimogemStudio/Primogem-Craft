
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class TiankongspItem extends Item {
	public TiankongspItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u5982\u679C\u52A0\u8F7D\u4E86TACz\u6A21\u7EC4"));
		list.add(Component.literal("\u00A77\u5219\u53EF\u4EE5\u5728\u67AA\u68B0\u5DE5\u4F5C\u53F0\u5151\u6362\u4E00\u628A\u00A7b\u5929\u7A7A"));
	}
}
