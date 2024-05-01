package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

public class Liulang_jingyan_shuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double jingyan = 0;
		if (!world.isClientSide()) {
			if (entity.isShiftKeyDown()) {
				if (itemstack.getDamageValue() == itemstack.getMaxDamage() - 1) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7c\u4E3A\u7A7A\uFF01"), false);
				} else {
					if (entity instanceof Player _player)
						_player.giveExperiencePoints((int) ((itemstack.getMaxDamage() - 1) - itemstack.getDamageValue()));
					if ((itemstack.getMaxDamage() - 1) - itemstack.getDamageValue() != 1) {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7e\u5DF2\u53D6\u51FA\uFF01"), false);
						if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
						} else {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.OFF_HAND, true);
						}
						YouhuayoujianfangfangzhiProcedure.execute();
					}
					itemstack.setDamageValue((int) (itemstack.getMaxDamage() - itemstack.getDamageValue() + (itemstack.getMaxDamage() - 1) - (itemstack.getMaxDamage() - itemstack.getDamageValue())));
					itemstack.getOrCreateTag().putDouble("naijiu_xianzhi", (itemstack.getMaxDamage() - itemstack.getDamageValue()));
					if (entity instanceof Player _player)
						_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
				}
			} else {
				if ((entity instanceof Player _plr ? _plr.experienceLevel : 0) != 0) {
					if (!(itemstack.getDamageValue() == 0)) {
						jingyan = DiaoyongjisuanjingyanzhiProcedure.execute(entity);
						if (entity instanceof Player _player)
							_player.giveExperiencePoints(-(itemstack.getDamageValue()));
						itemstack.setDamageValue((int) ((itemstack.getMaxDamage() - jingyan) - (itemstack.getMaxDamage() - itemstack.getDamageValue())));
						itemstack.getOrCreateTag().putDouble("naijiu_xianzhi", (itemstack.getMaxDamage() - itemstack.getDamageValue()));
						if (entity instanceof Player _player)
							_player.getCooldowns().addCooldown(itemstack.getItem(), 5);
						jingyan = 0;
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u503C\u00A7b\u5DF2\u5B58\u5165\uFF01"), false);
						if (itemstack.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.MAIN_HAND, true);
						} else {
							if (entity instanceof LivingEntity _entity)
								_entity.swing(InteractionHand.OFF_HAND, true);
						}
						YouhuayoujianfangfangzhiProcedure.execute();
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A7a\u7ECF\u9A8C\u4E66\u00A7c\u5DF2\u5B58\u6EE1\uFF01"), false);
					}
				}
			}
		}
	}
}
