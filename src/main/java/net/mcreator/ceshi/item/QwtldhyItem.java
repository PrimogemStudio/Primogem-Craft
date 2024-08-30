
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Tldhy_sx_2Procedure;

import java.util.List;

public class QwtldhyItem extends Item {
	public QwtldhyItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7d\u5B58\u5728\u7269\u54C1\u680F\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77 - \u63D0\u4F9B\u6C38\u4E45 \u901F\u5EA6 I \u6548\u679C"));
		list.add(Component.literal("\u00A77 - \u6BCF30\u79D2\u635F\u59311\u70B9\u751F\u547D\u503C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Tldhy_sx_2Procedure.execute(entity);
	}
}
