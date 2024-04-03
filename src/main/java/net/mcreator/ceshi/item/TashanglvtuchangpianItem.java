
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.TtashanglbtuteshuchufaProcedure;
import net.mcreator.ceshi.procedures.TashanglvtuxianzhitiaojianProcedure;

import java.util.List;

public class TashanglvtuchangpianItem extends RecordItem {
	public TashanglvtuchangpianItem() {
		super(5, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:tashanglvtu")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 3000);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		list.add(Component.literal("\u00A7b\u53F3\u952E\u7A7A\u6C14\u00A7f\u00A7a\u6216\u00A7f\u653E\u8FDB\u00A7b\u5531\u7247\u673A\u00A7f\u4EE5\u64AD\u653E"));
		list.add(Component.literal("\u00A7bps\uFF1A\u5531\u7247\u673A\u97F3\u8D28\u66F4\u597D\uFF01"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		TtashanglbtuteshuchufaProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TashanglvtuxianzhitiaojianProcedure.execute(context.getLevel(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
