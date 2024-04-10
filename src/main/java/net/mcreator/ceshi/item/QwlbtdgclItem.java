
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.QwlbtclsxProcedure;

import java.util.List;

public class QwlbtdgclItem extends Item {
	public QwlbtdgclItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A72\u5B58\u5728\u7269\u54C1\u680F\u4E14\u7269\u54C1\u680F\u4E2D\u62E5\u6709\u81F3\u5C11"));
		list.add(Component.literal("\u00A72 x45\u5B87\u5B99\u788E\u7247\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77\u6BCF\u4E2A\u6E38\u620F\u65E5\u00A78\uFF0824000tik\uFF09\u00A77\u8D60\u4E8810\uFF5E20\u5B87\u5B99\u788E\u7247"));
		list.add(Component.literal("\u00A77\u89E6\u53D1\u540E\uFF0C\u5982\u82E5\u6301\u6709\u5B87\u5B99\u788E\u7247\u603B\u6570\u203A64\u4E2A\u5219\u79FB\u9664\u6240"));
		list.add(Component.literal("\u00A77\u6709\u5B87\u5B99\u788E\u7247\u00A75\u5E76\u4EA7\u51FA\u5C11\u91CF\u6750\u6599"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwlbtclsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
