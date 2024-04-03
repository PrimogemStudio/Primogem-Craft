
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

import net.mcreator.ceshi.procedures.Flggz_sx_1Procedure;

import java.util.List;

public class QwggzfenlieAItem extends Item {
	public QwggzfenlieAItem() {
		super(new Item.Properties().durability(1396).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A76\u624B\u6301\u53F3\u952E\u652F\u4ED8\u00A7b1395\u00A76\u7ECF\u9A8C\u503C[\u00A7b30\u7ECF\u9A8C\u7B49\u7EA7\u00A76]"));
		list.add(Component.literal("\u00A76\u4EE5\u89E3\u9664\u8D1F\u9762\u6548\u679C\uFF01"));
		list.add(Component.literal("\u00A77\u653B\u51FB\u6700\u5927\u751F\u547D\u503C\u5C0F\u6216\u7B49\u4E8E\u81EA\u8EAB\u6700\u5927\u751F\u547D\u503C"));
		list.add(Component.literal("\u00A77\u7684\u4EA1\u7075\u751F\u7269\u65F6\uFF0C\u5C06\u6709\u00A7e5%\u00A77\u6982\u7387\u590D\u5236\u4E00\u4E2A\u540C"));
		list.add(Component.literal("\u00A77\u7C7B\u578B\u4EA1\u7075\u751F\u7269"));
		list.add(Component.literal("\u00A78\u8BE5\u5947\u7269\u6BCF\u4E94\u5206\u949F\u8FDB\u884C\u4E00\u6B21\u5206\u88C2\uFF0C\u81F3\u591A\u540C\u65F6"));
		list.add(Component.literal("\u00A78\u5B58\u57283\u4E2A\u590D\u5236\u54C1"));
		list.add(Component.literal("\u00A7c\u6301\u6709\u5206\u88C2\u5495\u5495\u949F\u590D\u5236\u54C1\u7684\u8D1F\u9762\u6548\u679C\u65F6\u65E0\u6CD5"));
		list.add(Component.literal("\u00A7c\u89E3\u9664\u8BE5\u5947\u7269\u63D0\u4F9B\u7684\u8D1F\u9762\u6548\u679C\uFF01"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Flggz_sx_1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
