
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.ChuangshijiejingWanJiaWanChengShiYongWuPinShiProcedure;

import java.util.List;

public class ChuangshijiejingItem extends Item {
	public ChuangshijiejingItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(5).saturationMod(3f).alwaysEat().build()));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A78\u5F88\u597D\u7684\u521B\u4E16\u7ED3\u6676\uFF0C\u4F7F\u6211\u4F24\u5BB3\u5438\u6536"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		ChuangshijiejingWanJiaWanChengShiYongWuPinShiProcedure.execute(entity, itemstack);
		return retval;
	}
}
