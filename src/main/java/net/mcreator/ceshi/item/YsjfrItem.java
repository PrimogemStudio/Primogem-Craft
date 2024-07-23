
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.network.chat.Component;

import java.util.List;

public class YsjfrItem extends Item {
	public YsjfrItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(1).saturationMod(0.1f).meat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A78\u65E0\u6CD5\u901A\u8FC7\u6B63\u5E38\u9014\u5F84\u83B7\u53D6"));
		list.add(Component.literal("\u00A70\u9003\u8BFE\u5C06\u83B7\u5F97\u5609\u5956\uFF01"));
		list.add(Component.literal("\u00A79\u9003\u8BFE\u5DE5\u827A \u7269\u54C1"));
	}
}
