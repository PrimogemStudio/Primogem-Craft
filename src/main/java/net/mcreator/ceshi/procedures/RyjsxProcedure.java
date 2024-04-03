package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class RyjsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.ZHUOSHAO.get()))) {
			if (itemstack.getItem() == PrimogemcraftModItems.RYTJ.get()) {
				if (Math.random() < ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQHUO.get())) : false) ? 0.375 : 0.25)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO.get(), 120, 0));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.RYZSJ.get()) {
				if (Math.random() < ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQHUO.get())) : false) ? 0.75 : 0.5)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO.get(), 120, 1));
				}
			}
			if (itemstack.getItem() == PrimogemcraftModItems.RYHJJ.get()) {
				if (Math.random() < ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQHUO.get())) : false) ? 1 : 0.75)) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.ZHUOSHAO.get(), 120, 2));
				}
			}
		}
	}
}
