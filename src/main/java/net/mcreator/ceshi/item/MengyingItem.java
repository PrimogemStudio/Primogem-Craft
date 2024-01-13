
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.MengyingsunhuaiProcedure;

import java.util.List;

public class MengyingItem extends Item {
	public MengyingItem() {
		super(new Item.Properties().durability(648).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u6301\u6709\u6B64\u7269\u54C1\u65F6\uFF0C\u5982\u82E5\u5728\u00A7d\u8FC7\u53BB\u00A77\u6548\u679C\u6301\u7EED\u671F\u95F4\u6B7B\u4EA1"));
		list.add(Component.literal("\u00A77\u5219\u89C6\u672C\u6B21\u6B7B\u4EA1\u65E0\u6548\u5E76\u89E6\u53D1\u8FC7\u53BB\u6548\u679C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		MengyingsunhuaiProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
