
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.MlsxProcedure;

import java.util.List;

public class Mmola01Item extends Item {
	public Mmola01Item() {
		super(new Item.Properties().stacksTo(64).fireResistant().rarity(Rarity.UNCOMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A77\u636E\u8BF4\u662F\u67D0\u4E2A\u4E16\u754C\u7684\u901A\u7528\u8D27\u5E01"));
		list.add(Component.literal("\u00A77\u4F46\u7EDD\u5BF9\u4E0D\u662F\u8FD9\u91CC"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MlsxProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
