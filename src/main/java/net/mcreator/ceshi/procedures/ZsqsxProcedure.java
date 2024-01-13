package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZsqsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if (itemstack.getOrCreateTag().getDouble("zsq_sx") == 0) {
				itemstack.getOrCreateTag().putDouble("zsq_sx", 10);
			}
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt((int) (itemstack.getMaxDamage() * 0.05), RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(),
						(int) ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQLEI.get())) : false)
								? itemstack.getOrCreateTag().getDouble("zsq_sx") * 20 * 1.5 * 0.5
								: itemstack.getOrCreateTag().getDouble("zsq_sx") * 20 * 1.5));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GUOQU.get(), (int) (itemstack.getOrCreateTag().getDouble("zsq_sx") * 20), 0));
		}
	}
}
