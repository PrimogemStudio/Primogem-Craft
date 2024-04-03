package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.PrimogemcraftMod;

public class ShshilianchouxiaoguoProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:shilianyinpin")), SoundSource.PLAYERS, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:shilianyinpin")), SoundSource.PLAYERS, 1, 1, false);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = PrimogemcraftModEntities.BAIGUANGGUODUSHENGWU.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		PrimogemcraftMod.queueServerWork(40, () -> {
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y + 7, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 7, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y + 6, y), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x + 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x + 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x + 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y + 6, z - 3), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 6, z - 3), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 6, z - 3), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x - 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x - 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x - 3, y + 6, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y + 6, z + 3), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 6, z + 3), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 6, z + 3), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x - 2, y + 6, z + 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
			if (Math.random() < 0.035) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x + 2, y + 6, z - 2), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		});
	}
}
