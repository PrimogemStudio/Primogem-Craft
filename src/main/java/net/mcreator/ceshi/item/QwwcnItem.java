
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

import net.mcreator.ceshi.procedures.QwwcnsxProcedure;

import java.util.List;

public class QwwcnItem extends Item {
	public QwwcnItem() {
		super(new Item.Properties().durability(20).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u4E0E\u4E07\u8BC6\u56CA\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A75\u00A7l\u65E0\u5BC4\u751F\u72B6\u6001\u65F6\u83B7\u5F97\u00A79\u5BC4\u751FII\u00A75\u72B6\u6001"));
		list.add(Component.literal("\u00A75\u7F50\u5B50\u6709\u6982\u7387\u6389\u843D\u866B\u7F51"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A79\u5BC4\u751FII\uFF1A"));
		list.add(Component.literal("\u00A79 +100%\u989D\u5916\u57FA\u7840\u653B\u51FB\u529B"));
		list.add(Component.literal("\u00A7c\u51FB\u6740\u751F\u7269\u540E\uFF1A"));
		list.add(Component.literal("\u00A7c -40%\u5F53\u524D\u751F\u547D\u503C"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		QwwcnsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
