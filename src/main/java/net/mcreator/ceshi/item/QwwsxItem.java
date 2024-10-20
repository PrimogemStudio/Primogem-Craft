
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

import net.mcreator.ceshi.procedures.QwwsxsxProcedure;

import java.util.List;

public class QwwsxItem extends Item {
	public QwwsxItem() {
		super(new Item.Properties().durability(20).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u7834\u574F\u7F50\u5B50\u5C06\u670950%\u6982\u7387\u6389\u843D\u989D\u5916\u7269\u54C1"));
		list.add(Component.literal("\u00A7f\u00A7l\u7F50\u5B50\u5C06\u6709\u6982\u7387\u6389\u843D\u9644\u9B54\u7269\u54C1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwwsxsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
