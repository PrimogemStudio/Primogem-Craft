
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

import net.mcreator.ceshi.procedures.WawanxiangwuchangtoushuxingProcedure;

import java.util.List;

public class WawanxiangwuchangtouItem extends Item {
	public WawanxiangwuchangtouItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.EPIC));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u4F7F\u7528\u540E\u5BF9\u526F\u624B\u5DF2\u9644\u9B54\u7269\u54C1"));
		list.add(Component.literal("\u00A77\u6DFB\u52A0\u4E00\u6B2130\u9644\u9B54\u7B49\u7EA7\u7684\u968F\u673A\u9644"));
		list.add(Component.literal("\u00A77\u9B54\uFF0C\u6BCF\u4EF6\u88C5\u5907\u4EC5\u53EF\u4F7F\u7528\u4E00\u6B21"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		WawanxiangwuchangtoushuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
