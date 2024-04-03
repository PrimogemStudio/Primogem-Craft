
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Flggz_B_sxProcedure;

import java.util.List;

public class QwggzfenlieBItem extends Item {
	public QwggzfenlieBItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A78\u589E\u52A0\u00A775%\u00A78\u590D\u5236\u6982\u7387"));
		list.add(Component.literal("\u00A78\u590D\u5236\u7684\u751F\u7269\u5C06\u88AB\u589E\u5F3A"));
		list.add(Component.literal("\u00A76\u624B\u6301\u53F3\u952E\u652F\u4ED835%\u751F\u547D\u503C\u4EE5\u51CF\u8F7B"));
		list.add(Component.literal("\u00A76\u6216\u89E3\u9664\u8BE5\u590D\u5236\u54C1\u63D0\u4F9B\u7684\u8D1F\u9762\u6548\u679C"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Flggz_B_sxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
