
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.Yiyijieguoshi_shuxingProcedure;

import java.util.List;

public class QwxxggItem extends Item {
	public QwxxggItem() {
		super(new Item.Properties().durability(2).rarity(Rarity.COMMON));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.literal("\u00A76\u4E0E\u5F02\u6728\u679C\u5B9E\u6548\u679C\u4E00\u81F4\uFF0C\u4F46"));
		list.add(Component.literal("\u00A7e\u4E34\u7EC8\u6548\u679C\u671F\u95F4\uFF0C\u6BCF\u6B21\u62FE\u53D6\u7ECF\u9A8C\u7403\u5C06"));
		list.add(Component.literal("\u00A7e\u91CD\u7F6E\u4E00\u6B21\u5DF2\u6D88\u8017\u7684\u514D\u4F24\u6B21\u6570"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Yiyijieguoshi_shuxingProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
