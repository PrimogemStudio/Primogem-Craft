
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

import net.mcreator.ceshi.procedures.YskstcqsxProcedure;

import java.util.List;

public class MllpzsItem extends Item {
	public MllpzsItem() {
		super(new Item.Properties().durability(1536).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u6F5C\u884C\u53F3\u952E\u5BF9\u811A\u4E0B\u65B9\u5757\u8FDB\u884C\u8BB0\u5F55"));
		list.add(Component.literal("\u00A77\u53F3\u952E\u5BFB\u627E\u00A7b3*y*3\u00A77\u8303\u56F4\u5185\u7684\u8BB0\u5F55\u65B9\u5757"));
		list.add(Component.literal("\u00A7b\u53EF\u4EE5\u641C\u5BFB\u7EDD\u5927\u90E8\u5206\u539F\u7248\u77FF\u7269\u65B9\u5757\uFF01"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		YskstcqsxProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}
}
