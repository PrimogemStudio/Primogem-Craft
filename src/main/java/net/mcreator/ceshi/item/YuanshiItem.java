
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import java.util.List;

public class YuanshiItem extends Item {
	public YuanshiItem() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.RARE).food((new FoodProperties.Builder()).nutrition(9).saturationMod(9f).alwaysEat().build()));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 40;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A78\u7ED9\u4ED620\u539F\u77F3\uFF0C\u4ED6\u80FD\u5E2E\u4F60..."));
	}
}
