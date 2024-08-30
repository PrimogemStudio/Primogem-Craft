package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

public class ZizaifushuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isInWaterOrBubble()) {
			if (!(entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(MobEffects.DOLPHINS_GRACE))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 240, 1, false, false));
				{
					ItemStack _ist = itemstack;
					_ist.hurtAndBreak(Mth.nextInt(RandomSource.create(), 4, 8), RandomSource.create(), null, () -> {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					});
				}
			}
		} else {
			if (!(entity instanceof LivingEntity _livEnt6 && _livEnt6.hasEffect(MobEffects.MOVEMENT_SPEED))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 240, 1, false, false));
				{
					ItemStack _ist = itemstack;
					_ist.hurtAndBreak(4, RandomSource.create(), null, () -> {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					});
				}
			}
		}
	}
}
