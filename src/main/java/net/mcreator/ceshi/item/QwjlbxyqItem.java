
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

import net.mcreator.ceshi.procedures.HtdzsxProcedure;

import java.util.List;

public class QwjlbxyqItem extends Item {
	public QwjlbxyqItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u653B\u51FB\u751F\u7269\u65F6\uFF0C\u5C06\u81EA\u8EAB10%\u6700\u5927\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77\u7B49\u7EA7\u7684 \u751F\u547D\u5782\u5371 \u6548\u679C\u8D4B\u4E88\u751F\u7269"));
		list.add(Component.literal("\u00A7c\u00A7l\u6BCF\u7EA7\u6548\u679C\u51CF\u5C11\u51762\u70B9\u751F\u547D\u503C\u4E0A\u9650"));
		list.add(Component.literal("\u00A77\u00A7l \u6548\u679C\u6301\u7EED10s\uFF0C\u89E6\u53D1\u540E\u51B7\u537415s"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HtdzsxProcedure.execute(entity);
	}
}
