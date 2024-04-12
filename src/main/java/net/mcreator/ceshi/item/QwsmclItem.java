
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.SmclsxProcedure;

import java.util.List;

public class QwsmclItem extends Item {
	public QwsmclItem() {
		super(new Item.Properties().durability(5).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u653B\u51FB\u4EA1\u7075\u751F\u7269\u65F6\u6709\u6982\u7387\u5BF9\u5176\u8FDB\u884C"));
		list.add(Component.literal("\u00A77\u5F3A\u5316"));
		list.add(Component.literal("\u00A76\u51FB\u8D25\u5F3A\u5316\u540E\u7684\u4EA1\u7075\u751F\u7269\u65F6\u5C06\u6709\u6982"));
		list.add(Component.literal("\u00A76\u7387\u6389\u843D2~20\u5B87\u5B99\u788E\u7247"));
		list.add(Component.literal("\u00A79\u89E6\u53D15\u6B21\u540E\u8BE5\u5947\u7269\u5C06\u635F\u574F"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		SmclsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
