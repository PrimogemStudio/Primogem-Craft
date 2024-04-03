
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Ljtg3sxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

public class XzcfyxwzdItem extends ShieldItem {
	public XzcfyxwzdItem() {
		super(new Item.Properties().durability(2048).fireResistant());
	}

	@Override
	public boolean isValidRepairItem(ItemStack itemstack, ItemStack repairitem) {
		return Ingredient.of(new ItemStack(PrimogemcraftModItems.JINZHIMOLA.get()), new ItemStack(PrimogemcraftModItems.JLLIANG.get())).test(repairitem);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u66F4\u534E\u4E3D\u7684\u5783\u573E\u6876\u76D6\u7F62\u4E86\uFF01"));
		list.add(Component.literal(""));
		list.add(Component.literal("\u00A76 \u2022 \u6297\u6027\u63D0\u5347"));
		list.add(Component.literal("\u00A78 \u6C38\u4E45\u63D0\u4F9B\u6297\u6027\u63D0\u5347 I"));
		list.add(Component.literal("\u00A76 \u2022 \u8D81\u624B"));
		list.add(Component.literal("\u00A78 \u6D88\u8017\u8010\u4E45\u62B5\u5FA1\u683C\u6321\u5931\u8D25"));
		list.add(Component.literal("\u00A78 \u540E\u88AB\u65BD\u52A0\u7684\u51B7\u5374"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Ljtg3sxProcedure.execute(entity, itemstack);
	}
}
