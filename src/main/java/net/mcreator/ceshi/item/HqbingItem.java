
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.List;

public class HqbingItem extends Item {
	public HqbingItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A79\u5BF9\u4E8E\u54C0\u53D9\u51B0\u7389\u7CFB\u5217\u88C5\u5907\uFF1A"));
		list.add(Component.literal(" \u00A7a+50%\u00A78 \u00A7/ \u00A7d+0.5"));
		list.add(Component.literal(" \u00A77\u6982\u7387\u00A78 \u00A7/ \u00A7/ \u00A7/ \u00A77\u5957\u88C5\u6570\u503C"));
		list.add(Component.literal(" \u00A7e-50%"));
		list.add(Component.literal(" \u00A77\u51B7\u5374"));
		list.add(Component.literal("\u00A78\u4EC5\u4F5C\u7528\u4E8E\u6B63\u9762\u6548\u679C"));
	}
}
