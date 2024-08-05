package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEntities;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.List;
import java.util.Comparator;

public class XixiangyuzhiyuanchoukaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			new ItemStack(PrimogemcraftModItems.XIXIANGYUZHIYUAN.get()).shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:choukaqianxi01")), SoundSource.BLOCKS, 70, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:choukaqianxi01")), SoundSource.BLOCKS, 70, 1, false);
				}
			}
			if (entity.getPersistentData().getDouble("xiangyu_baodi_zi") >= 9) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				entity.getPersistentData().putDouble("xiangyu_baodi_zi", 0);
			} else {
				if (Math.random() < 0.1) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.Q_QYUANCHUZI_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					entity.getPersistentData().putDouble("xiangyu_baodi_zi", 0);
				} else {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = PrimogemcraftModEntities.QQ_QYUANCHULAN_01.get().spawn(_level, BlockPos.containing(x, y + 10, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
					entity.getPersistentData().putDouble("xiangyu_baodi_zi", (entity.getPersistentData().getDouble("xiangyu_baodi_zi") + 1));
				}
			}
			{
				final Vec3 _center = new Vec3(x, (y + 10), z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if (entityiterator.getType().is(TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation("pgc:qiyuan")))) {
						PrimogemcraftMod.queueServerWork(1, () -> {
							entityiterator.getPersistentData().putBoolean("kechou", true);
						});
					}
				}
			}
		}
	}
}
