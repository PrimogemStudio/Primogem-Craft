
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

import net.mcreator.ceshi.procedures.QwwsgsxProcedure;

import java.util.List;

public class QwwsgItem extends Item {
	public QwwsgItem() {
		super(new Item.Properties().durability(4).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7e\u989D\u5916\u83B7\u5F97\u4E00\u500D\u7684\u6548\u679C\u65F6\u957F"));
		list.add(Component.literal("\u00A7e\u4E14\u514D\u4F24\u6B21\u6570\u589E\u52A0\u523010\u6B21"));
		list.add(Component.literal("\u00A7c\u4E0D\u80FD\u8FDE\u7EED\u89E6\u53D1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwwsgsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
