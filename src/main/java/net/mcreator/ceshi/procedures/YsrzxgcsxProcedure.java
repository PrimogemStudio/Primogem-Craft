package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class YsrzxgcsxProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		a = new ItemStack(PrimogemcraftModItems.YSRZ_0.get());
		a.getOrCreateTag().putDouble("cao", 1);
		a.setHoverName(Component.literal("\u00A7a\u5143\u7D20\u7194\u73E0"));
		a.getOrCreateTag().putBoolean("qidong", true);
		if (!(entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(a) : false)) {
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(PrimogemcraftModMobEffects.YSRZXG.get());
			if (entity instanceof LivingEntity _entity)
				_entity.removeEffect(MobEffects.HEALTH_BOOST);
		}
	}
}
