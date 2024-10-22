
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

import net.mcreator.ceshi.procedures.QwclgssxProcedure;

import java.util.List;

public class QwclgsItem extends Item {
	public QwclgsItem() {
		super(new Item.Properties().durability(3).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u00A7l\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A79\u89E6\u53D1\u65F6\u81EA\u8EAB\u6389\u843D2~20\u5B87\u5B99\u788E\u7247"));
		list.add(Component.literal("\u00A7c\u00A7l\u4E34\u7EC8\u671F\u95F4\u865A\u5F31\u6548\u679C\u8F6C\u53D8\u4E3A\u529B\u91CF"));
		list.add(Component.literal("\u00A7c\u00A7l\u6548\u679C\uFF0C\u4F46\u6301\u7EED\u65F6\u95F4\u548C\u7B49\u7EA7\u51CF\u534A"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwclgssxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
