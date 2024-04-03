package net.mcreator.ceshi.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@Mod.EventBusSubscriber
public class YpjsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getDirectEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		execute(null, world, entity, immediatesourceentity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity immediatesourceentity, Entity sourceentity) {
		if (entity == null || immediatesourceentity == null || sourceentity == null)
			return;
		if (immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false) {
			PrimogemcraftMod.queueServerWork(10, () -> {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)),
									(float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8));
						}
					}
				}
			});
		}
		if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false) {
			PrimogemcraftMod.queueServerWork(10, () -> {
				{
					final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator instanceof Player) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8) {
							entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.PLAYER_ATTACK)),
									(float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8));
						}
					}
				}
			});
		}
	}
}
