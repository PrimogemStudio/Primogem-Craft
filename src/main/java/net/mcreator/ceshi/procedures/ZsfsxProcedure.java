package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

public class ZsfsxProcedure {
	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity, ItemStack itemstack) {
		if (entity == null || sourceentity == null)
			return;
		if (itemstack.getOrCreateTag().getDouble("zsq_sx") <= 0) {
			itemstack.getOrCreateTag().putDouble("zsq_sx", 10);
		}
		if (!itemstack.getOrCreateTag().getBoolean("zsf_sx")) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.GUOQU.get(), (int) (itemstack.getOrCreateTag().getDouble("zsq_sx") * 20), 0));
			itemstack.getOrCreateTag().putBoolean("zsf_sx", true);
		}
		if (itemstack.getOrCreateTag().getBoolean("zsf_sx")) {
			PrimogemcraftMod.queueServerWork((int) (itemstack.getOrCreateTag().getDouble("zsq_sx") * 20 * 0.5), () -> {
				itemstack.getOrCreateTag().putBoolean("zsf_sx", false);
			});
			if (sourceentity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(),
						(int) ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQLEI.get())) : false)
								? itemstack.getOrCreateTag().getDouble("zsq_sx") * 20 * 0.5 * 0.5
								: itemstack.getOrCreateTag().getDouble("zsq_sx") * 20 * 0.5));
		}
	}
}
