
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

import net.mcreator.ceshi.procedures.QwcbzgsxProcedure;

import java.util.List;

public class QwcbzgItem extends Item {
	public QwcbzgItem() {
		super(new Item.Properties().durability(3).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u6548\u679C\u4E0E\u5F02\u6728\u679C\u5B9E\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A77\u89E6\u53D1\u540E\u53EF\u83B7\u5F97\u4E8B\u4EF6\u8865\u507F\u5238(\u4F4E~\u4E2D)"));
		list.add(Component.literal("\u00A77\u5141\u8BB8\u4F7F\u75283\u6B21\u00A7c\u00A7l\u4E0D\u80FD\u8FDE\u7EED\u89E6\u53D1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwcbzgsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
