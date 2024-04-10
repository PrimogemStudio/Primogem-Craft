
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

import net.mcreator.ceshi.procedures.Qcmx_sxProcedure;

import java.util.List;

public class QwqcxxmxItem extends Item {
	public QwqcxxmxItem() {
		super(new Item.Properties().stacksTo(1).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A72\u53F3\u952E\u540E\u6D88\u8017\u6240\u6709\u5B87\u5B99\u788E\u7247\u83B7\u5F97"));
		list.add(Component.literal("\u00A72\u529B\u91CF\u6548\u679C"));
		list.add(Component.literal("\u00A77\u529B\u91CF\u7B49\u7EA7=\u5B87\u5B99\u788E\u7247\u9664\u4EE516"));
		list.add(Component.literal("\u00A77\u521D\u59CB\u6301\u7EED1\u5206\u949F"));
		list.add(Component.literal("\u00A76\u6F5C\u884C+\u53F3\u952E\u6BCF\u6B21\u6D88\u8017\u6700\u5927\u6301\u7EED\u65F6\u95F4\u6570\u91CF\u7684"));
		list.add(Component.literal("\u00A76\u5B87\u5B99\u788E\u7247\u6765\u63D0\u53471\u79D2\u6700\u5927\u6301\u7EED\u65F6\u95F4"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Qcmx_sxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
