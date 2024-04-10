
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Qwjlbbgsx1Procedure;

import java.util.List;

public class QwtcjlbptbgItem extends Item {
	public QwtcjlbptbgItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A76 - \u62FE\u53D6\u7ECF\u9A8C\u7403\u7684\u6536\u76CA\u63D0\u5347100%"));
		list.add(Component.literal("\u00A78 \u4F46\u4F1A\u5C06\u5B87\u5B99\u788E\u7247\u8F6C\u5316\u4E3A\u7ECF\u9A8C\u503C"));
		list.add(Component.literal("\u00A75\u5B87\u5B99\u788E\u7247\u00A7fx1\u00A7b\u00BB\u00A75\u7ECF\u9A8C\u503C\u00A7fx8"));
		list.add(Component.literal("\u00A78 \u8F6C\u5316256\u5B87\u5B99\u788E\u7247\u540E\u9500\u6BC1"));
		list.add(Component.literal("\u00A7c\u5947\u7269\u88AB\u9500\u6BC1\u540E\u6263\u966450%\u5F53\u524D\u7ECF\u9A8C\u503C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Qwjlbbgsx1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
