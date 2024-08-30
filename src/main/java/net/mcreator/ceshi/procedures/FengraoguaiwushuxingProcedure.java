package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.tags.EntityTypeTags;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import javax.annotation.Nullable;

@EventBusSubscriber
public class FengraoguaiwushuxingProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.getType().is(EntityTypeTags.UNDEAD) && (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGMINGZHI))) {
			if (world.getDifficulty() == Difficulty.EASY) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 100) {
					if (Math.random() < 0.05 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 100) {
					if (Math.random() < 0.03 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
			}
			if (world.getDifficulty() == Difficulty.NORMAL) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 100) {
					if (Math.random() < 0.1 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 100) {
					if (Math.random() < 0.05 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
			}
			if (world.getDifficulty() == Difficulty.HARD) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= 100) {
					if (Math.random() < 0.18 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) >= 100) {
					if (Math.random() < 0.1 * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEMOYINSHENSHENGCHENGBEILV))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.FENGRAO, 2000000, 0));
					}
				}
			}
		}
	}
}
