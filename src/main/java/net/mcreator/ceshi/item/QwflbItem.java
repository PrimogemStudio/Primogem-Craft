
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

import net.mcreator.ceshi.procedures.QwflbsxProcedure;

import java.util.List;

public class QwflbItem extends Item {
	public QwflbItem() {
		super(new Item.Properties().durability(24).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u5206\u88C2\u91D1\u5E01\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A77 \u4EA7\u51FA\u4E00\u6216\u591A\u4E2A\u5B87\u5B99\u788E\u7247\uFF0C\u9700\u8981"));
		list.add(Component.literal("\u00A77 \u66F4\u957F\u7B49\u5F85\u65F6\u95F4\uFF0C\u4E00\u5B9A\u6B21\u6570\u540E\u81EA"));
		list.add(Component.literal("\u00A77 \u7136\u6D88\u5931"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwflbsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
