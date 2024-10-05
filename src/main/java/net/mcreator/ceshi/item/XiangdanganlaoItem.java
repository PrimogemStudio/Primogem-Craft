
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.XxiangdangaolaozaibeibaoshiProcedure;
import net.mcreator.ceshi.procedures.XixiangdanganlaoshiyongxiaoguoProcedure;

import java.util.List;

public class XiangdanganlaoItem extends Item {
	public XiangdanganlaoItem() {
		super(new Item.Properties().durability(1).fireResistant().rarity(Rarity.COMMON).food((new FoodProperties.Builder()).nutrition(0).saturationModifier(0f).alwaysEdible().build()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u5B58\u5728\u7269\u54C1\u680F\u65F6\uFF1A"));
		list.add(Component.literal("\u00A77\u62FE\u53D6\u7ECF\u9A8C\u7403\u65F6\u6062\u590D\u5C11\u91CF\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77\u5C0F\u6982\u7387\u635F\u574F\uFF01"));
		list.add(Component.literal("\u00A7"));
		list.add(Component.literal("\u00A75\u5F53\u98DF\u7528\u540E\uFF1A"));
		list.add(Component.literal("\u00A79\u6062\u590D30%\u751F\u547D\u503C"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		return ar;
	}

	@Override
	public ItemStack finishUsingItem(ItemStack itemstack, Level world, LivingEntity entity) {
		ItemStack retval = super.finishUsingItem(itemstack, world, entity);
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		XixiangdanganlaoshiyongxiaoguoProcedure.execute(world, x, y, z, entity);
		return retval;
	}

	@Override
	public boolean onDroppedByPlayer(ItemStack itemstack, Player entity) {
		XxiangdangaolaozaibeibaoshiProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity);
		return true;
	}
}
