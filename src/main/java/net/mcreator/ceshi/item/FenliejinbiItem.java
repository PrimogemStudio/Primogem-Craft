
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

import net.mcreator.ceshi.procedures.FenliejinbishuxingProcedure;

import java.util.List;

public class FenliejinbiItem extends Item {
	public FenliejinbiItem() {
		super(new Item.Properties().durability(12).rarity(Rarity.UNCOMMON));
	}

	@Override
	public int getEnchantmentValue() {
		return -100;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u968F\u7740\u65F6\u95F4\u7684\u63A8\u79FB\uFF0C\u83B7\u5F97\u5B87\u5B99\u788E\u7247"));
		list.add(Component.literal("\u00A77\u4E00\u5B9A\u6B21\u6570\u540E\u9500\u6BC1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		FenliejinbishuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
