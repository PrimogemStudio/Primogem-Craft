
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

import net.mcreator.ceshi.procedures.Yiyijieguoshi_shuxingProcedure;

import java.util.List;

public class YiyimuguoshiItem extends Item {
	public YiyimuguoshiItem() {
		super(new Item.Properties().durability(3).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u73A9\u5BB6\u6B7B\u4EA1\u65F6\uFF0C\u4E3A\u5176\u63D0\u4F9B\u4E00\u5206\u949F\u7684\u989D\u5916\u751F\u547D"));
		list.add(Component.literal("\u00A77\u671F\u95F4\u514D\u75AB5\u6B21\u4EFB\u610F\u4F24\u5BB3"));
		list.add(Component.literal("\u00A7c\u4E34\u7EC8\u6548\u679C\u7ED3\u675F\u540E\u4F1A\u5C1D\u8BD5\u6740\u6B7B\u73A9\u5BB6"));
		list.add(Component.literal("\u00A7a\u4E0D\u80FD\u8FDE\u7EED\u89E6\u53D1"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Yiyijieguoshi_shuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
