
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Ljtg2sxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class Ljtg02Item extends ShieldItem {
	public Ljtg02Item() {
		super(new Item.Properties().durability(1500));
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(PrimogemcraftModItems.JLZA.get()), new ItemStack(Items.IRON_INGOT)).test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u624B\u611F\u597D\u50CF\u8FD8\u4E0D\u9519\uFF1F"));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A76 \u2022 \u5783\u573E\u6876\u7684\u987D\u5F3A\uFF01"));
		list.add(Component.literal("\u00A78 \u53D7\u5230\u653B\u51FB\u65F6\u67094%\u51E0\u7387\u514D\u75AB"));
		list.add(Component.literal("\u00A78 \u8FD9\u6B21\u4F24\u5BB3\uFF01"));
		list.add(Component.literal("\u00A76 \u2022 \u8D81\u624B"));
		list.add(Component.literal("\u00A78 \u6D88\u8017\u8010\u4E45\u62B5\u5FA1\u683C\u6321\u5931\u8D25\u540E"));
		list.add(Component.literal("\u00A78 \u88AB\u65BD\u52A0\u7684\u51B7\u5374"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Ljtg2sxProcedure.execute(entity, itemstack);
	}
}
