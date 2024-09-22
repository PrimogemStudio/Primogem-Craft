
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

import net.mcreator.ceshi.procedures.QwwxwcxsxProcedure;

import java.util.List;

public class QwwxwcxItem extends Item {
	public QwwxwcxItem() {
		super(new Item.Properties().durability(2).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u53F3\u952E\u540E\u5BF9\u526F\u624B\u672A\u9644\u9B54\u7269\u54C1\u5C1D\u8BD5"));
		list.add(Component.literal("\u00A76 \u63D0\u4F9B20\u7ECF\u9A8C\u7B49\u7EA7\u9644\u9B54"));
		list.add(Component.literal("\u00A77\u540C\u4E00\u7269\u54C1\u6216\u5947\u7269\u672C\u8EAB\uFF0C\u90FD\u53EF"));
		list.add(Component.literal("\u00A77 \u4F7F\u7528\u4E24\u6B21"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		QwwxwcxsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
