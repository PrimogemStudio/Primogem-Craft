
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

import net.mcreator.ceshi.procedures.Wxntdmj_wp_sxProcedure;

import java.util.List;

public class QwwxntdmjItem extends Item {
	public QwwxntdmjItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u653B\u51FB\u6EE1\u751F\u547D\u503C\u751F\u7269\u65F6\u6263\u9664"));
		list.add(Component.literal("\u00A77\u81EA\u8EAB50%\u5F53\u524D\u9971\u98DF\u5EA6"));
		list.add(Component.literal("\u00A78\u6BCF20\u79D2\u81F3\u591A\u89E6\u53D11\u6B21"));
		list.add(Component.literal("\u00A76\u98DF\u7528\u00A7b\u5495\u949F\u4E09\u660E\u6CBB\u00A76\u6765\u89E3\u9664\u8D1F\u9762\u6548\u679C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Wxntdmj_wp_sxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
