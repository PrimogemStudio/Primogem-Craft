
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

import net.mcreator.ceshi.procedures.Yiyijieguoshi_shuxingProcedure;

import java.util.List;

public class QwypzgsItem extends Item {
	public QwypzgsItem() {
		super(new Item.Properties().durability(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A75\u6BCF\u6B21\u514D\u75AB\u4F24\u5BB3\u65F6\u670920%\u6982\u7387\u5BF9"));
		list.add(Component.literal("\u00A75\u653B\u51FB\u8005\u9020\u6210\u4E00\u6B21\u653B\u51FB\u8005\u6700\u5927\u751F"));
		list.add(Component.literal("\u00A75\u547D\u503C20%\u7684\u9B54\u6CD5\u4F24\u5BB3"));
		list.add(Component.literal("\u00A7c\u00A7l\u4F24\u5BB3\u4E0D\u662F\u7531\u4F60\u9020\u6210\u7684\uFF01"));
		list.add(Component.literal("\u00A7c\u00A7l\u4EC5\u53EF\u89E6\u53D1\u4E00\u6B21"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Yiyijieguoshi_shuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
