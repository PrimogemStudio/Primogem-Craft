
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

import net.mcreator.ceshi.procedures.Qyhc_wjc_sxProcedure;

import java.util.List;

public class Qyhx0wujiachengItem extends Item {
	public Qyhx0wujiachengItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.qyhx_0wujiacheng.description_0"));
		list.add(Component.translatable("item.primogemcraft.qyhx_0wujiacheng.description_1"));
		list.add(Component.translatable("item.primogemcraft.qyhx_0wujiacheng.description_2"));
		list.add(Component.translatable("item.primogemcraft.qyhx_0wujiacheng.description_3"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			Qyhc_wjc_sxProcedure.execute(entity, itemstack);
	}
}
