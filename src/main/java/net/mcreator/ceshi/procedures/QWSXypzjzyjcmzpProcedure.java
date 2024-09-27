package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

import java.util.List;
import java.util.Comparator;

@EventBusSubscriber
public class QWSXypzjzyjcmzpProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getSource(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		execute(null, world, damagesource, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, DamageSource damagesource, Entity entity, Entity sourceentity) {
		if (damagesource == null || entity == null || sourceentity == null)
			return;
		double a = 0;
		double b = 0;
		if (!world.isClientSide()) {
			if (!damagesource.is(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("primogemcraft:s_hchixushanghai")))) {
				if ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.CHUNMEIZHIPAO.get())) : false)
						&& !(sourceentity instanceof Player _plrCldCheck3 && _plrCldCheck3.getCooldowns().isOnCooldown(PrimogemcraftModItems.CHUNMEIZHIPAO.get()))) {
					if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
						for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
							ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == PrimogemcraftModItems.YUZHOUSUIPIAN.get()) {
								a = a + itemstackiterator.getCount();
								b = a * 0.015625;
							}
						}
					}
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(PrimogemcraftModItems.CHUNMEIZHIPAO.get(), 40);
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("primogemcraft:s_hchixushanghai"))), sourceentity),
							Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.016 * b));
				}
				if ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWJZYJ.get())) : false)
						&& !(sourceentity instanceof Player _plrCldCheck14 && _plrCldCheck14.getCooldowns().isOnCooldown(PrimogemcraftModItems.QWJZYJ.get()))) {
					if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
						for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
							ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
							if (itemstackiterator.is(ItemTags.create(new ResourceLocation("c:curio/bad")))) {
								a = a + itemstackiterator.getCount();
							}
						}
					}
					if (sourceentity instanceof Player _player)
						_player.getCooldowns().addCooldown(PrimogemcraftModItems.QWJZYJ.get(), 20);
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("primogemcraft:s_hchixushanghai"))), sourceentity),
							(float) (Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.003 * a) > Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 3)
									? Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 3)
									: Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.003 * a)));
				}
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false) {
					{
						final Vec3 _center = new Vec3((entity.getX()), (entity.getY()), (entity.getZ()));
						List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(2 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
						for (Entity entityiterator : _entfound) {
							if (!(entityiterator == sourceentity) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) >= (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8) {
								entityiterator.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(ResourceKey.create(Registries.DAMAGE_TYPE, new ResourceLocation("primogemcraft:s_hchixushanghai"))),
										sourceentity), (float) ((entityiterator instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) - (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8));
							}
						}
					}
				}
			}
		}
	}
}
