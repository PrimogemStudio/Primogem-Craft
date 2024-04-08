
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

import net.mcreator.ceshi.procedures.Ydggz_sx_1Procedure;

import java.util.List;

public class YdggzItem extends Item {
	public YdggzItem() {
		super(new Item.Properties().durability(31).rarity(Rarity.COMMON));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A79\u62FE\u53D6\u540E\u89E6\u53D1\uFF1A"));
		list.add(Component.literal("\u00A77\u6BCF3\u5206\u949F\u6263\u9664\u81EA\u8EAB5%\u5F53\u524D\u7ECF\u9A8C\u503C"));
		list.add(Component.literal("\u00A77\u51FB\u6740\u751F\u7269\u6709\u6982\u7387\u6389\u843D\u00A7e\u5495\u949F\u96F6\u4EF6\u00A77"));
		list.add(Component.literal("\u00A76\u624B\u6301\u8BE5\u7269\u54C1\u53F3\u952E\u6D88\u8017\u5495\u949F\u96F6\u4EF6\u4FEE\u590D"));
		list.add(Component.literal("\u00A76\u8BE5\u7269\u54C1\uFF0C\u5B8C\u5168\u4FEE\u590D\u65F6\u89E3\u9664\u8D1F\u9762\u6548\u679C"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Ydggz_sx_1Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
