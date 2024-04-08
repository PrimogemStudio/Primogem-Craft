
package net.mcreator.ceshi.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Shenmihuaban_shuxingProcedure;
import net.mcreator.ceshi.procedures.FaguangkaiqiProcedure;

import java.util.List;

public class ShenshenghuabanItem extends Item {
	public ShenshenghuabanItem() {
		super(new Item.Properties().durability(100).fireResistant().rarity(Rarity.COMMON));
	}

	@Override
	public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
		return 0f;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		return FaguangkaiqiProcedure.execute(itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("\u00A77\u53F3\u952E\u5730\u9762\u00A7b\u53EC\u5524\u00A77\u865A\u62DF\u9ED1\u5854"));
		list.add(Component.literal("\u00A77\u53F3\u952E\u865A\u62DF\u9ED1\u5854\u4EE5\u00A7e\u56DE\u6536"));
		list.add(Component.literal("\u00A78\u5B83\u771F\u597D\u770B"));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		Shenmihuaban_shuxingProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
