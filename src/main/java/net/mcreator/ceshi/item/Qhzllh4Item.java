
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

import net.mcreator.ceshi.procedures.ZllhsxProcedure;

import java.util.List;

public class Qhzllh4Item extends Item {
	public Qhzllh4Item() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.EPIC));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A78\u53F2\u8BD7\u793C\u76D220%\u6982\u7387\u8F6C\u5316"));
		list.add(Component.literal("\u00A7e[\u53F3\u952E]\u00A77\u4F7F\u7528\u4E00\u4E2A"));
		list.add(Component.literal("\u00A7b[\u6F5C\u884C+\u53F3\u952E]\u00A77\u4F7F\u7528\u5168\u90E8"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ZllhsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
