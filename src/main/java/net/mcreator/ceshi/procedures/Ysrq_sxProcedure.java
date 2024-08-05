package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Ysrq_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		double c = 0;
		double d = 0;
		double e = 0;
		double a1 = 0;
		double b1 = 0;
		double f = 0;
		if (!world.isClientSide()) {
			if (itemstack.getOrCreateTag().getBoolean("yan")) {
				c = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQYAN.get())) : false) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(MobEffects.DAMAGE_RESISTANCE))) {
					if (c >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, (int) (c - 7), true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.ABSORPTION))) {
					if (c >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 900, (int) (c * 0.5 - 1), true, false));
					}
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("feng")) {
				b = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQFENG.get())) : false) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(MobEffects.SLOW_FALLING)) && !entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
					if (b >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt14 && _livEnt14.hasEffect(MobEffects.JUMP))) {
					if (b >= 4) {
						if (!entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b + 2), true, false));
						} else {
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b - 1), true, false));
						}
					}
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("lei")) {
				d = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQLEI.get())) : false) ? 10 : 8;
				if (entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(PrimogemcraftModMobEffects.GOUYU.get())) {
					if (d >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 60, (int) (d - 6), true, false));
					}
				}
				if (world.getLevelData().isRaining() || world.getLevelData().isThundering()) {
					if (d >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 60, (int) (d * 0.5 - 2), true, false));
					}
					if (d >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60, (int) (d * 0.5 - 3), true, false));
					}
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("cao")) {
				a = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQCAO.get())) : false) ? 10 : 8;
				if (a >= 2) {
					if (Math.random() < 0.0005) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.SATURATION, 10, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt31 && _livEnt31.hasEffect(MobEffects.HEALTH_BOOST)) && !(entity instanceof LivingEntity _livEnt32 && _livEnt32.hasEffect(PrimogemcraftModMobEffects.SZTSXCWDP.get()))) {
					entity.getPersistentData().putDouble("yuanbenshengminzhi", (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
					if (a >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200000, (int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) * Math.round(a) * 0.1), true, false));
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.YSRZXG.get(), 200000, 0, false, false));
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) != Math
							.floor((entity.getPersistentData().getDouble("yuanbenshengminzhi") / 4) * Math.floor(a) * 0.1) || a < 4) {
						entity.getPersistentData().putBoolean("yuanbenshengminzhi", false);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.HEALTH_BOOST);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP.get(), 20, 0, false, false));
					}
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("shui")) {
				e = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQSHUI.get())) : false) ? 10 : 8;
				if (e >= 2) {
					if (!(entity instanceof LivingEntity _livEnt46 && _livEnt46.hasEffect(MobEffects.CONDUIT_POWER))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.CONDUIT_POWER, 80, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt48 && _livEnt48.hasEffect(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get())) && entity.isAlive()) {
					if (e >= 4) {
						if (e < 6) {
							a1 = e * 20;
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * e * 0.5 * 0.02));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get(), (int) a1, 0, false, false));
						} else {
							b1 = e * 20 * 0.5;
							if (entity instanceof LivingEntity _entity)
								_entity.setHealth((float) ((entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) + (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * e * 0.5 * 0.03));
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get(), (int) b1, 0, false, false));
						}
					}
				}
			}
			if (itemstack.getOrCreateTag().getBoolean("huo")) {
				f = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQHUO.get())) : false) ? 10 : 8;
				if (!(entity instanceof LivingEntity _livEnt61 && _livEnt61.hasEffect(MobEffects.FIRE_RESISTANCE))) {
					if (f >= 2) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 80, 0, true, false));
					}
				}
				if (!(entity instanceof LivingEntity _livEnt63 && _livEnt63.hasEffect(PrimogemcraftModMobEffects.RYKJXG.get()))) {
					if (f >= 4) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.RYKJXG.get(), 1200, (int) Math.round(f - 1), false, false));
					}
				}
				if (entity instanceof LivingEntity _livEnt65 && _livEnt65.hasEffect(PrimogemcraftModMobEffects.RYKJXG.get())) {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.RYKJXG.get()) ? _livEnt.getEffect(PrimogemcraftModMobEffects.RYKJXG.get()).getAmplifier() : 0) != Math.round(f - 1)) {
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(PrimogemcraftModMobEffects.RYKJXG.get());
					}
				}
			}
		}
	}
}
