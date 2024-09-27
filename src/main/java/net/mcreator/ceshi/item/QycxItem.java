
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

import net.mcreator.ceshi.procedures.Ysdc_sxProcedure;

import java.util.List;

public class QycxItem extends Item {
	public QycxItem() {
		super(new Item.Properties().stacksTo(64).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u540E\u5411\u73A9\u5BB6\u64AD\u62A5\u5185\u6DB5\u7684\u7948\u613F\u8BE6\u60C5"));
		list.add(Component.literal("\u00A77\u6F5C\u884C+\u53F3\u952E\u67E5\u8BE2/\u91CD\u7F6E"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Ysdc_sxProcedure.execute(entity, ar.getObject());
		return ar;
	}
}
