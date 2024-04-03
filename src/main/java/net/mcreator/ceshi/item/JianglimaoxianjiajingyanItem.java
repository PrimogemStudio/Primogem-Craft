
package net.mcreator.ceshi.item;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

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

import net.mcreator.ceshi.procedures.JingyanshutongyongsuijijingyanjiangliProcedure;
import net.mcreator.ceshi.procedures.Jingyanshushuxing2Procedure;
import net.mcreator.ceshi.procedures.Jingyanshushuxing1Procedure;
import net.mcreator.ceshi.procedures.Jingyanshushuxing0Procedure;
import net.mcreator.ceshi.procedures.HechengxiufujingyanquchuProcedure;

import java.util.List;

public class JianglimaoxianjiajingyanItem extends Item {
	public JianglimaoxianjiajingyanItem() {
		super(new Item.Properties().stacksTo(1).fireResistant().rarity(Rarity.RARE));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFoil(ItemStack itemstack) {
		Entity entity = Minecraft.getInstance().player;
		return Jingyanshushuxing0Procedure.execute(entity, itemstack);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
		Entity entity = itemstack.getEntityRepresentation();
		double x = entity != null ? entity.getX() : 0.0;
		double y = entity != null ? entity.getY() : 0.0;
		double z = entity != null ? entity.getZ() : 0.0;
		list.add(Component.literal(Jingyanshushuxing1Procedure.execute(world, itemstack)));
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		JingyanshutongyongsuijijingyanjiangliProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, ar.getObject());
		return ar;
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Level world, Player entity) {
		super.onCraftedBy(itemstack, world, entity);
		HechengxiufujingyanquchuProcedure.execute(itemstack);
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		Jingyanshushuxing2Procedure.execute();
	}
}
