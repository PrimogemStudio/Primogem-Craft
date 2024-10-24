
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

import net.mcreator.ceshi.procedures.QwclhysxProcedure;

import java.util.List;

public class QwclhyItem extends Item {
	public QwclhyItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u795E\u79D8\u78C1\u529B\u89E6\u53D1\u65F6\u5FC5\u5B9A\u989D\u5916\u751F\u6210"));
		list.add(Component.literal("\u00A77\u4E00\u4E2A\u5F3A\u5316\u4EA1\u7075\u751F\u7269"));
		list.add(Component.literal("\u00A7c\u00A7l\u6BCF\u6B21\u89E6\u53D1\u5C06\u670920%\u6982\u7387\u635F\u574F"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwclhysxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
