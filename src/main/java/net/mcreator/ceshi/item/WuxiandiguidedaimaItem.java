
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

import net.mcreator.ceshi.procedures.FumianqiwufaguangProcedure;
import net.mcreator.ceshi.procedures.DiguidaimashuxingProcedure;

import java.util.List;

public class WuxiandiguidedaimaItem extends Item {
	public WuxiandiguidedaimaItem() {
		super(new Item.Properties().durability(31).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return FumianqiwufaguangProcedure.execute(itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_0"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_1"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_2"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_3"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_4"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_5"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_6"));
		list.add(Component.translatable("item.primogemcraft.wuxiandiguidedaima.description_7"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		DiguidaimashuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
