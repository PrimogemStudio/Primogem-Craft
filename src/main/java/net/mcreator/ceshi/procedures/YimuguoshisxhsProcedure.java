package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class YimuguoshisxhsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, boolean sunhuai, double sudu_dengji) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("yijieguoshi_kaiqi")) {
			if (sunhuai) {
				{
					ItemStack _ist = itemstack;
					_ist.hurtAndBreak(1, RandomSource.create(), null, () -> {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					});
				}
				if (itemstack.getDamageValue() == itemstack.getMaxDamage()) {
					itemstack.shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6, false);
						}
					}
					DiaoyongqwyisunhuaiProcedure.execute(entity, itemstack);
				}
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			entity.getPersistentData().putBoolean("yijieguoshi_kaiqi", false);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.LINZHONG, 1200, 0));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 9));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, (int) sudu_dengji));
		}
		if (!(entity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(PrimogemcraftModMobEffects.QWYMGS)) && !(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(PrimogemcraftModMobEffects.LINZHONG))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QWYMGS, 20, 0));
		}
	}
}
