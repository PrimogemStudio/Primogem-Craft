package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class CeshihufuProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		itemstack.getOrCreateTag().putDouble("sanyuezhufu", (itemstack.getOrCreateTag().getDouble("sanyuezhufu") + 1));
		if (itemstack.getOrCreateTag().getDouble("sanyuezhufu") >= 24000) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			itemstack.getOrCreateTag().putDouble("sanyuezhufu", 0);
		}
		if (!(entity instanceof LivingEntity _livEnt10 && _livEnt10.hasEffect(PrimogemcraftModMobEffects.SYZF.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SYZF.get(), 60, 0, false, false));
		}
	}
}
