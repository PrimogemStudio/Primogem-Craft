
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Ysrq_sx_0Procedure;
import net.mcreator.ceshi.procedures.Ysrq_sxProcedure;

import java.util.List;

public class Ysrz0Item extends Item {
	public Ysrz0Item() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u540E\u8F6C\u53D8\u5F62\u6001\uFF0C\u5E76\u6301\u6709\u968F\u673A\u5143\u7D20\u5957\u76848\u6570\u503C\u6548\u679C"));
		list.add(Component.literal("\u00A77\u5B58\u5728\u7269\u54C1\u680F\u65F6\u5C06\u4E3A\u73A9\u5BB6\u63D0\u4F9B\u589E\u76CA"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Ysrq_sx_0Procedure.execute(world, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Ysrq_sxProcedure.execute(world, entity, itemstack);
	}
}
