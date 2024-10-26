
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

import net.mcreator.ceshi.procedures.QwyznjsxProcedure;

import java.util.List;

public class QwyznjItem extends Item {
	public QwyznjItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u4E3A\u526F\u624B\u7269\u54C1\u8D4B\u4E881~20\u7EA7\u9644\u9B54\u7B49\u7EA7\u9644\u9B54"));
		list.add(Component.literal("\u00A7l\u5C06\u7ED9\u4E88:\u950B\u5229\u3001\u4FDD\u62A4\u3001\u6548\u7387 \u5176\u4E2D\u4E00\u79CD"));
		list.add(Component.literal("\u00A7c\u00A7l\u5E76\u4F7F\u5176\u83B7\u5F97 \u611A\u8005\u4E4B\u6012V \u8BC5\u5492"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		QwyznjsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
