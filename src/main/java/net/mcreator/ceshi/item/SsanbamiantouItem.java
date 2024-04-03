
package net.mcreator.ceshi.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.SsanbamiantouxiaoguoProcedure;

import java.util.List;

public class SsanbamiantouItem extends Item {
	public SsanbamiantouItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.BOW;
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 16;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A79\u53F3\u952E\u4F7F\u7528\u540E\uFF1A"));
		list.add(Component.literal("\u00A77\u968F\u673A\u8F6C\u5316\u7269\u54C1\u680F\u4E2D\u5305\u62EC\u81EA\u8EAB\u6240\u5728"));
		list.add(Component.literal("\u00A77\u7684\u6240\u6709\u79CD\u7C7B\u5947\u7269"));
		list.add(Component.literal("\u00A78\u540C\u79CD\u7C7B\u4F1A\u6839\u636E\u60C5\u51B5\u8F6C\u5316\u4E00\u6216\u591A\u4EF6"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		SsanbamiantouxiaoguoProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity);
		return ar;
	}
}
