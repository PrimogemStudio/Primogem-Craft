
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Hdlz_sx_1Procedure;

import java.util.List;

public class QwhdlzItem extends Item {
	public QwhdlzItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u6740\u6B7B64\u53EA\u4EA1\u7075\u751F\u7269\u6216\u8282\u80A2\u751F\u7269\u540E\uFF0C\u4E3A"));
		list.add(Component.literal("\u00A77\u526F\u624B\u7269\u54C1\u6DFB\u52A0\u4E00\u6B21\u968F\u673A1\u7EA7\u9644\u9B54"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A7c\u4E0D\u4F1A\u663E\u793A\u8FDB\u5EA6\u4E14\u5355\u4E00\u88C5\u5907\u81F3\u591A\u89E6\u53D1\u4E24\u6B21"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Hdlz_sx_1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
