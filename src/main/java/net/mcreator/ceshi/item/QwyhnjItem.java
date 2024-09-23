
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.QwyhnjsxProcedure;

import java.util.List;

public class QwyhnjItem extends Item {
	public QwyhnjItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A7e\u00A7l\u53F3\u952E\u4EE5\u4F7F\u7528"));
		list.add(Component.literal("\u00A76\u4F7F\u7528\u540E\u6709\u5927\u6982\u7387\u53D7\u5230\u6700\u5927\u751F\u547D"));
		list.add(Component.literal("\u00A76 \u503C95%\u7684\u9B54\u6CD5\u4F24\u5BB3"));
		list.add(Component.literal("\u00A76\u5C0F\u6982\u7387\u83B7\u5F971~2\u4E2A\u9AD8\u54C1\u8D28\u4E8B\u4EF6"));
		list.add(Component.literal("\u00A76 \u9644\u9B54\u5238"));
		list.add(Component.literal("\u00A75\u00A7l\u89E6\u53D1\u540E\u8BE5\u5947\u7269\u635F\u574F"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		QwyhnjsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
