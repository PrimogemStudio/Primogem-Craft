
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

import net.mcreator.ceshi.procedures.XgsbmtsxProcedure;

import java.util.List;

public class QwxgdbmtItem extends Item {
	public QwxgdbmtItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u00A7d\u00A7l\u95EA\u8000\u7684\u504F\u65B9\u4E09\u516B\u9762\u9AB0\u00A7r\u00A76\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7e\u8F6C\u5316\u81EA\u8EAB\u4EE5\u5916\u7684\u5947\u7269\u65F6\uFF0C\u6BCF\u8F6C\u531610\u79CD\u5176"));
		list.add(Component.literal("\u00A7e\u4ED6\u5947\u7269\u5219\u00A7l\u989D\u5916\u83B7\u5F97\u4E00\u4E2A\u968F\u673A\u5947\u7269"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		XgsbmtsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
