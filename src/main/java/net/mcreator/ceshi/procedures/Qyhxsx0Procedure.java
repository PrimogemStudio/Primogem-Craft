package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

public class Qyhxsx0Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!world.isClientSide()) {
			if (!(itemstack.getOrCreateTag().getDouble("qyhx_cishu") > 29)) {
				if (!((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == itemstack.getItem())
						&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Blocks.COMMAND_BLOCK.asItem()) {
						a = 1000;
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("pgc:qysz_10")))) {
						a = 10;
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("pgc:qysz_7")))) {
						a = 7;
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("pgc:qysz_5")))) {
						a = 5;
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("pgc:qysz_3")))) {
						a = 3;
					} else {
						a = 1;
					}
					if (entity.isShiftKeyDown()) {
						c = itemstack.getMaxDamage() - (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1);
						b = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount();
						if (c > b) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink((int) b);
							itemstack.getOrCreateTag().putDouble("Prayers_strengthen", (itemstack.getOrCreateTag().getDouble("Prayers_strengthen") + b * a));
							itemstack.getOrCreateTag().putDouble("qyhx_cishu", (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + b));
							itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1)));
						} else {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink((int) c);
							itemstack.getOrCreateTag().putDouble("Prayers_strengthen", (itemstack.getOrCreateTag().getDouble("Prayers_strengthen") + c * a));
							itemstack.getOrCreateTag().putDouble("qyhx_cishu", (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + c));
							itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1)));
						}
					} else {
						(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).shrink(1);
						itemstack.getOrCreateTag().putDouble("Prayers_strengthen", (itemstack.getOrCreateTag().getDouble("Prayers_strengthen") + a));
						itemstack.getOrCreateTag().putDouble("qyhx_cishu", (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1));
						itemstack.setDamageValue((int) (itemstack.getMaxDamage() - (itemstack.getOrCreateTag().getDouble("qyhx_cishu") + 1)));
					}
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7c\u526F\u624B\u7269\u54C1\u65E0\u6548\uFF01"), false);
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7c\u8BE5\u7269\u54C1\u52A0\u6210\u5DF2\u8FBE\u6700\u5927\uFF01"), false);
			}
		}
	}
}
