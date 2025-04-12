package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

public class Tiankongsx0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double nr1 = 0;
		if (!world.isClientSide()) {
			nr1 = 0.142;
			if (Math.random() < nr1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 40, 0, false, false));
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.MOB_PROJECTILE), sourceentity), 1, 6), entity, sourceentity);
			} else if (Math.random() < nr1) {
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.CRAMMING), sourceentity), 1, 7), entity, sourceentity);
			} else if (Math.random() < nr1) {
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.LIGHTNING_BOLT), sourceentity), 1, 3), entity, sourceentity);
				if (world instanceof ServerLevel _level) {
					LightningBolt entityToSpawn = EntityType.LIGHTNING_BOLT.create(_level);
					entityToSpawn.moveTo(Vec3.atBottomCenterOf(BlockPos.containing(x, y, z)));
					entityToSpawn.setVisualOnly(true);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if (Math.random() < nr1) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.POISON, 40, 0, false, false));
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.MAGIC), sourceentity), 1, 5), entity, sourceentity);
			} else if (Math.random() < nr1) {
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.IN_WALL), sourceentity), 1, 2), entity, sourceentity);
			} else if (Math.random() < nr1) {
				entity.igniteForSeconds(3);
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.IN_FIRE), sourceentity), 1, 1), entity, sourceentity);
			} else {
				entity.setTicksFrozen(60);
				Tiankongsx1Procedure.execute(world, ToElementDamageProcedure.execute(new DamageSource(world.holderOrThrow(DamageTypes.FREEZE), sourceentity), 1, 4), entity, sourceentity);
			}
		}
	}
}
