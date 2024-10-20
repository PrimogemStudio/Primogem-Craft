
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

import net.mcreator.ceshi.procedures.QwwswctsxProcedure;

import java.util.List;

public class QwwswctItem extends Item {
	public QwwswctItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A77\u4E0E\u4E07\u8C61\u65E0\u5E38\u9AB0\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u5C06\u540C\u65F6\u5BF9\u526F\u624B\u7269\u54C1\u63D0\u4F9B\u968F\u673A\u7B49\u7EA7\u7684"));
		list.add(Component.literal("\u201C\u5F00\u7F50\u5668\u201D\u9644\u9B54\uFF0C\u6BCF\u7EA7\u63D0\u4F9B10%\u7F50\u5B50"));
		list.add(Component.literal("\u6389\u843D\u989D\u5916\u6218\u5229\u54C1\u6389\u843D\u6982\u7387"));
		list.add(Component.literal("\u00A7e\u00A7l\u53EF\u4E0E\u5947\u7269\u6548\u679C\u53E0\u52A0"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		QwwswctsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
