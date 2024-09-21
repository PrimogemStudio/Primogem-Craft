package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

import javax.annotation.Nullable;

@EventBusSubscriber
public class Yimuguoxiaoguoshuxing2Procedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (!world.isClientSide()) {
			if (entity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PrimogemcraftModMobEffects.LINZHONG)) {
				if (entity.getPersistentData().getDouble("ymgs_xz") < 5) {
					if (entity.getPersistentData().getBoolean("ypz_ymgs") && Math.random() < 0.2) {
						sourceentity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.MAGIC)),
								(float) ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.2));
					}
					if (event instanceof ICancellableEvent _cancellable) {
						_cancellable.setCanceled(true);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, (float) 0.2, 20);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.anvil.place")), SoundSource.NEUTRAL, (float) 0.2, 20, false);
						}
					}
					entity.getPersistentData().putDouble("ymgs_xz", (entity.getPersistentData().getDouble("ymgs_xz") + 1));
				}
			}
		}
	}
}
