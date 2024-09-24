
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.KwglsxProcedure;
import net.mcreator.ceshi.procedures.Kwglsx0Procedure;

import java.util.List;

public class QwkwglItem extends Item {
	public QwkwglItem() {
		super(new Item.Properties().durability(1).rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	public boolean hasCraftingRemainingItem() {
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
		list.add(Component.literal("\u62FE\u53D6\u7ECF\u9A8C\u7403\u65F6\uFF0C\u6709\u6982\u7387\u5C11\u91CF\u4FEE\u590D\u526F\u624B"));
		list.add(Component.literal("\u5947\u7269\uFF0C\u4FEE\u590D\u540E\u8BE5\u5947\u7269\u6982\u7387\u635F\u574F"));
		list.add(Component.literal("\u00A7a\u5408\u6210\u4EE5\u4FEE\u590D\u4E00\u4E2A\u5DF2\u635F\u574F\u5947\u7269"));
		list.add(Component.literal("\u00A7e\u98DF\u7528\u540E\u6062\u590D30%\u751F\u547D\u503C"));
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		Kwglsx0Procedure.execute(world, x, y, z, entity);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		KwglsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
