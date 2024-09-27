
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

import net.mcreator.ceshi.procedures.Luodejingshe_shuxingProcedure;

import java.util.List;

public class PengkeluodejingshenItem extends Item {
	public PengkeluodejingshenItem() {
		super(new Item.Properties().durability(10).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	public boolean hasCraftingRemainingItem(ItemStack stack) {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		ItemStack retval = new ItemStack(this);
		retval.setDamageValue(itemstack.getDamageValue() + 1);
		if (retval.getDamageValue() >= retval.getMaxDamage()) {
			return ItemStack.EMPTY;
		}
		return retval;
	}

	@Override
	public boolean isRepairable(ItemStack itemstack) {
		return false;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A79\u8D4B\u4E88\u6218\u6597\u72B6\u6001"));
		list.add(Component.literal("\u00A7d\u5904\u4E8E\u6218\u6597\u72B6\u6001\u4E0B\uFF1A"));
		list.add(Component.literal("\u00A77\u88AB\u653B\u51FB\u65F6\uFF0C\u5C06\u670950%\u6982\u7387\u5BF9\u653B\u51FB\u8005\u65BD\u52A0\uFF1A"));
		list.add(Component.literal("\u00A77 - \u51CB\u96F6 I \uFF085s\uFF09"));
		list.add(Component.literal("\u00A77 - \u7F13\u6162 III \uFF085s\uFF09"));
		list.add(Component.literal("\u00A77 - \u5931\u660E III \uFF085s\uFF09"));
		list.add(Component.literal("\u00A77 - \u9ED1\u6697 III \uFF085s\uFF09"));
		list.add(Component.literal("\u00A77\u5176\u4E2D\u4E00\u79CD"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Luodejingshe_shuxingProcedure.execute(entity);
	}
}
