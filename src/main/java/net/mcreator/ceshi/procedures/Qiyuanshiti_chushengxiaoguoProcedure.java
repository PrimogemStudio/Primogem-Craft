package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;

import java.util.List;
import java.util.Comparator;

public class Qiyuanshiti_chushengxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI.get(), (int) (entity instanceof QQQyuanchulan01Entity ? 40 : 20), 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 5, false, false));
		if (!world.isClientSide()) {
			if (entity instanceof QQQyuanchulan01Entity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getDouble("chouka") > 0) {
							if (!entityiterator.getPersistentData().getBoolean("xiangyu")
									&& (Math.random() < 0.03 || (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi >= 49)) {
								{
									double _setval = 0;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.jin_baodi = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_jin + 1;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.wj_ck_jin = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								{
									double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi + 1;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.zi_baodi = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
							} else if (Math.random() < 0.2 || (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi >= 9) {
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_zi + 1;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.wj_ck_zi = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									{
										double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi + 1;
										entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.jin_baodi = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
								}
								{
									double _setval = 0;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.zi_baodi = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else {
								entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
								{
									double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).wj_ck_lan + 1;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.wj_ck_lan = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									{
										double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).jin_baodi + 1;
										entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
											capability.jin_baodi = _setval;
											capability.syncPlayerVariables(entityiterator);
										});
									}
								}
								{
									double _setval = (entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PrimogemcraftModVariables.PlayerVariables())).zi_baodi + 1;
									entityiterator.getCapability(PrimogemcraftModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
										capability.zi_baodi = _setval;
										capability.syncPlayerVariables(entityiterator);
									});
								}
								entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
								entity.getPersistentData().putBoolean("chouka_jiance_0", true);
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							}
						} else {
							entityiterator.getPersistentData().putBoolean("chouka", false);
						}
					}
				}
			}
			if (entity instanceof QQyuanchuzi01Entity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("chouka")) {
							entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
							entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
							entity.getPersistentData().putBoolean("chouka_jiance_1", true);
						}
					}
				}
			}
			if (entity instanceof QqiyuanJinGuangEntity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getBoolean("chouka") || entityiterator.getPersistentData().getBoolean("baodi_shoudong")) {
							entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
							if (entityiterator.getPersistentData().getBoolean("baodi_shoudong")) {
								entityiterator.getPersistentData().putBoolean("baodi_shoudong", false);
							} else {
								entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
							}
							entity.getPersistentData().putBoolean("chouka_jiance_2", true);
						}
					}
				}
			}
		}
	}
}
