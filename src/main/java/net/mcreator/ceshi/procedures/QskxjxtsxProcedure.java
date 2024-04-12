package net.mcreator.ceshi.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class QskxjxtsxProcedure {
	@SubscribeEvent
	public static void onUseItemFinish(LivingEntityUseItemEvent.Finish event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getItem());
		}
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.QSKXJXTXG.get()) && (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) > 0) {
			if (entity instanceof Player _player)
				_player.getFoodData()
						.setFoodLevel((int) ((entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) * 0.5 >= 20
								+ (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) * 0.5
										? 20
										: (entity instanceof Player _plr ? _plr.getFoodData().getFoodLevel() : 0) - (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getNutrition() : 0) * 0.5));
			if ((itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) > 0) {
				if (entity instanceof Player _player)
					_player.getFoodData()
							.setSaturation((float) ((entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) + (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) * 0.8 >= 8
									+ (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) * 0.8
											? 8
											: (entity instanceof Player _plr ? _plr.getFoodData().getSaturationLevel() : 0) - (itemstack.getItem().isEdible() ? itemstack.getItem().getFoodProperties().getSaturationModifier() : 0) * 0.8));
			}
		}
	}
}
