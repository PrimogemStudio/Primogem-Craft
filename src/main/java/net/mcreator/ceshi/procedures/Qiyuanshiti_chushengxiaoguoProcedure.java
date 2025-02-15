package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.entity.QqiyuanJinGuangEntity;
import net.mcreator.ceshi.entity.QQyuanchuzi01Entity;
import net.mcreator.ceshi.entity.QQQyuanchulan01Entity;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.List;
import java.util.Comparator;

public class Qiyuanshiti_chushengxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean o1 = false;
		double a = 0;
		double b = 0;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DJQJKJXGXIANZHI, (int) (entity instanceof QQQyuanchulan01Entity ? 40 : 20), 0, false, false));
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1200, 5, false, false));
		if (!world.isClientSide()) {
			if (entity instanceof QQQyuanchulan01Entity) {
				{
					final Vec3 _center = new Vec3(x, (y - 10), z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(40 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (entityiterator.getPersistentData().getDouble("chouka") > 0) {
							a = entityiterator.getPersistentData().getBoolean("xiangyu")
									? 0.01
									: 0.03 + (entityiterator.getPersistentData().getDouble("chouka_jiacheng") > 0 ? (entityiterator.getPersistentData().getDouble("Prayers_strengthen") / 10) * 0.01 : 0);
							b = entityiterator.getPersistentData().getBoolean("xiangyu")
									? 0.1
									: 0.2 + (entityiterator.getPersistentData().getDouble("chouka_jiacheng") > 0 ? (entityiterator.getPersistentData().getDouble("Prayers_strengthen") / 5) * 0.01 : 0);
							if (Math.random() < a || entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jin_baodi >= 49) {
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.jin_baodi = 0;
									_vars.syncPlayerVariables(entityiterator);
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
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.wj_ck_jin = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_jin + 1;
									_vars.syncPlayerVariables(entityiterator);
								}
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.zi_baodi = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).zi_baodi + 1;
									_vars.syncPlayerVariables(entityiterator);
								}
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else if (Math.random() < b || entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).zi_baodi >= 9) {
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.wj_ck_zi = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_zi + 1;
									_vars.syncPlayerVariables(entityiterator);
								}
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									{
										PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
										_vars.jin_baodi = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jin_baodi + 1;
										_vars.syncPlayerVariables(entityiterator);
									}
								}
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.zi_baodi = 0;
									_vars.syncPlayerVariables(entityiterator);
								}
								entityiterator.getPersistentData().putBoolean("xiangyu", false);
							} else {
								entity.getPersistentData().putString("qiyuan_guishu", (entityiterator.getDisplayName().getString()));
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.wj_ck_lan = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).wj_ck_lan + 1;
									_vars.syncPlayerVariables(entityiterator);
								}
								if (!entityiterator.getPersistentData().getBoolean("xiangyu")) {
									{
										PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
										_vars.jin_baodi = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jin_baodi + 1;
										_vars.syncPlayerVariables(entityiterator);
									}
								}
								{
									PrimogemcraftModVariables.PlayerVariables _vars = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES);
									_vars.zi_baodi = entityiterator.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).zi_baodi + 1;
									_vars.syncPlayerVariables(entityiterator);
								}
								entityiterator.getPersistentData().putDouble("chouka", (entityiterator.getPersistentData().getDouble("chouka") - 1));
								entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
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
							entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
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
								entityiterator.getPersistentData().putDouble("chouka_jiacheng", (entityiterator.getPersistentData().getDouble("chouka_jiacheng") - 1));
							}
							entity.getPersistentData().putBoolean("chouka_jiance_2", true);
						}
					}
				}
			}
			if (entity instanceof QqiyuanJinGuangEntity) {
				if (Math.random() < (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEBUHUOMINGGUANGZHI)) * 0.01) {
					o1 = true;
					PrimogemcraftMod.queueServerWork(20, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:bhmg_y")), SoundSource.NEUTRAL, 4, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:bhmg_y")), SoundSource.NEUTRAL, 4, 1, false);
							}
						}
					});
				}
			}
		}
		if (o1) {
			PrimogemcraftMod.queueServerWork(40, () -> {
				if (entity instanceof QqiyuanJinGuangEntity _datEntSetL)
					_datEntSetL.getEntityData().set(QqiyuanJinGuangEntity.DATA_bhmg, true);
				entity.getPersistentData().putBoolean("lizi", true);
			});
		}
	}
}
