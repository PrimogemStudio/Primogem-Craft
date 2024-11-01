
package net.mcreator.ceshi.item;

import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.procedures.Liulang_jingyan_shuxingProcedure;
import net.mcreator.ceshi.procedures.Jingyanshu_beibaonaijiuProcedure;
import net.mcreator.ceshi.procedures.Dayingxiong_shu_faguangProcedure;

import java.util.List;

public class MaoxianjiadejingyanItem extends Item {
	public MaoxianjiadejingyanItem() {
		super(new Item.Properties().durability(1090).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return Dayingxiong_shu_faguangProcedure.execute(entity, itemstack);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, list, flag);
		list.add(Component.translatable("item.primogemcraft.maoxianjiadejingyan.description_0"));
		list.add(Component.translatable("item.primogemcraft.maoxianjiadejingyan.description_1"));
		list.add(Component.translatable("item.primogemcraft.maoxianjiadejingyan.description_2"));
		list.add(Component.translatable("item.primogemcraft.maoxianjiadejingyan.description_3"));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		Liulang_jingyan_shuxingProcedure.execute(world, entity, ar.getObject());
		return ar;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Jingyanshu_beibaonaijiuProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
	}
}
