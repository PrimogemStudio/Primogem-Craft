
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

import net.mcreator.ceshi.procedures.SbmjbsxProcedure;

import java.util.List;

public class QwsbmbItem extends Item {
	public QwsbmbItem() {
		super(new Item.Properties().durability(12).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u968F\u7740\u65F6\u95F4\u7684\u63A8\u79FB\uFF0C\u83B7\u5F97\u5947\u7269"));
		list.add(Component.literal("\u00A75\u00A7l\u5FC5\u5B9A\u4E3A\u8D1F\u9762\u5947\u7269\uFF01"));
		list.add(Component.literal("\u00A75 \u4F46\u6BCF\u6B21\u89E6\u53D1\u65F650%\u6982\u7387\u8FDB\u884C"));
		list.add(Component.literal("\u00A75 \u4E00\u6B21\u300E\u95EA\u8000\u7684\u504F\u65B9\u4E09\u516B\u9762\u9AB0\u300F"));
		list.add(Component.literal("\u00A75 \u6548\u679C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SbmjbsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
