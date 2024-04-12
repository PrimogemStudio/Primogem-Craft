
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Qskxjxt_sxProcedure;

import java.util.List;

public class QwqskxjxtItem extends Item {
	public QwqskxjxtItem() {
		super(new Item.Properties().durability(100).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u98DF\u7528\u98DF\u7269\u540E\u51CF\u5C1150%\u9971\u98DF\u5EA6\u6536\u76CA"));
		list.add(Component.literal("\u00A77\u540C\u65F6\u51CF\u5C1180%\u9971\u548C\u5EA6\u6536\u76CA"));
		list.add(Component.literal("\u00A78\u5BF9\u653E\u7F6E\u7C7B\u98DF\u7269\u4E0D\u53D7\u5F71\u54CD"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Qskxjxt_sxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
