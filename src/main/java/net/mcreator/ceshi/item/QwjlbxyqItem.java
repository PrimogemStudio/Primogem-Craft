
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
		list.add(Component.literal("\u00A77\u653B\u51FB\u751F\u7269\u65F6\uFF0C\u5C06\u51CF\u5C11\u5176\u7684\u6700\u5927\u751F\u547D"));
		list.add(Component.literal("\u00A77\u503C\uFF0C\u51CF\u5C11\u91CF\u4E3A\u5F53\u524D\u4F7F\u7528\u8005\u6700\u5927\u751F\u547D"));
		list.add(Component.literal("\u00A77\u503C\u76845%"));
		list.add(Component.literal("\u00A77\u00A7l \u6548\u679C\u6301\u7EED10s\uFF0C\u89E6\u53D1\u540E\u51B7\u537415s"));
		list.add(Component.literal("\u00A7e\u6BCF\u6B21\u89E6\u53D1\u540E20%\u6389\u843D1\u4E2A\u5B87\u5B99\u788E\u7247"));
		list.add(Component.literal("\u00A7a\u00A7l\u643A\u5E26\u540E\u9ED1\u5854\u5546\u5E97\u5947\u7269\u4EF7\u683C\u51CF\u5C1120%"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		HtdzsxProcedure.execute(entity);
	}
}
