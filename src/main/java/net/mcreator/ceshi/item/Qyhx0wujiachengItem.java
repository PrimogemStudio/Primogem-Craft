
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Qyhc_wjc_sxProcedure;

import java.util.List;

public class Qyhx0wujiachengItem extends Item {
	public Qyhx0wujiachengItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u00A7l\u65E0\u52A0\u6210\u7248\u672C\uFF0C\u4FBF\u4E8E\u5408\u6210"));
		list.add(Component.literal("\u00A75\u624B\u6301\u65F6:"));
		list.add(Component.literal("\u00A77 \u00A7 \u00A7 \u9010\u6B65\u66FF\u6362\u4E3A\u52A0\u6210\u7248\u672C"));
		list.add(Component.literal("\u00A76 \u00A7 \u00A7 \u6F5C\u884C\u00A77\u4EE5\u66FF\u6362\u5168\u90E8"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Qyhc_wjc_sxProcedure.execute(context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
