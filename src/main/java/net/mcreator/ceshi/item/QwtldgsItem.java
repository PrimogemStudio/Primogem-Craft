
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

import net.mcreator.ceshi.procedures.QwtldgssxProcedure;

import java.util.List;

public class QwtldgsItem extends Item {
	public QwtldgsItem() {
		super(new Item.Properties().durability(3).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7e\u00A7l\u4E34\u7EC8\u6548\u679C\u7ED3\u675F\u65F6\u4E0D\u4F1A\u6740\u6B7B\u73A9\u5BB6"));
		list.add(Component.literal("\u00A78\u6548\u679C\u89E6\u53D1\u540E2\u5206\u949F\u4EE5\u5185\u4E0D\u80FD\u89E6\u53D1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwtldgssxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
