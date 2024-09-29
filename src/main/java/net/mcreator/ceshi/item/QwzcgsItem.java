
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

import net.mcreator.ceshi.procedures.QwcgsxProcedure;

import java.util.List;

public class QwzcgsItem extends Item {
	public QwzcgsItem() {
		super(new Item.Properties().durability(4).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7c\u89E6\u53D1\u540E\u4E3A\u9644\u8FD1\u6700\u5927\u751F\u547D\u503C\u5C0F\u6216\u7B49\u4E8E\u81EA\u8EAB"));
		list.add(Component.literal("\u00A7c\u5341\u500D\u6700\u5927\u751F\u547D\u503C\u7684\u4EFB\u4F55\u751F\u7269"));
		list.add(Component.literal("\u00A75\u8D4B\u4E88\uFF1A"));
		list.add(Component.literal("\u00A79 \u5BC4\u751FV\uFF0800:20\uFF09"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwcgsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
