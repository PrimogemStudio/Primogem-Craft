package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;

public class JijiuchanzhiyuanWanJiaWanChengShiYongWuPinShiProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		new ItemStack(PrimogemcraftModItems.JIJIUCHANZHIYUAN.get()).shrink(1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 70, 1);
			} else {
				_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:choukaqianxi01")), SoundSource.HOSTILE, 70, 1, false);
			}
		}
		if (Math.random() < 0.03) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PrimogemcraftModEntities.QQIYUAN_JIN_GUANG.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
		} else {
			if (entity.getPersistentData().getDouble("baodi_zi") >= 9) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				entity.getPersistentData().putDouble("baodi_zi", 0);
			} else {
				if (Math.random() < 0.15) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					entity.getPersistentData().putDouble("baodi_zi", 0);
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					entity.getPersistentData().putDouble("baodi_zi", (entity.getPersistentData().getDouble("baodi_zi") + 1));
				}
			}
		}
	}
}
