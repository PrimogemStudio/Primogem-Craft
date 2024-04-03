package net.mcreator.ceshi.procedures;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class JiasuyuanjieshuxingProcedure {
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
		double a = 0;
		double b = 0;
		if (sourceentity instanceof Player && (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWJZYJ.get())) : false)
				&& !(sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.JIAZUXIANZHI.get()))) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:curio/bad")))) {
							a = a + itemstackiterator.getCount();
						}
					}
				}
			}
			entity.getPersistentData().putDouble("jiazu_shengjie_shuxing",
					(Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.003 * a) > Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 3)
							? Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 3)
							: Math.round((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.003 * a)));
			if (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)) {
				PrimogemcraftMod.queueServerWork((int) (!(sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.CHUNMEIZHIPAO.get())) : false) ? 10 : 20), () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
				});
			} else {
				if (sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.CHUNMEIZHIPAO.get())) : false) {
					PrimogemcraftMod.queueServerWork((int) ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8 ? 30 : 20), () -> {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
							});
				} else {
					PrimogemcraftMod.queueServerWork((int) ((sourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8 ? 20 : 10), () -> {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
							});
				}
			}
			if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JIAZUXIANZHI.get(), 20, 0, false, false));
		}
		if (immediatesourceentity instanceof Player && (immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWJZYJ.get())) : false)
				&& !(immediatesourceentity instanceof LivingEntity _livEnt37 && _livEnt37.hasEffect(PrimogemcraftModMobEffects.JIAZUXIANZHI.get()))) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				immediatesourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(new ResourceLocation("forge:curio/bad")))) {
							a = a + itemstackiterator.getCount();
						}
					}
				}
			}
			entity.getPersistentData().putDouble("jiazu_shengjie_shuxing",
					(Math.round((immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.005 * a) > Math.round((immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.3)
							? Math.round((immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.3)
							: Math.round((immediatesourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.005 * a)));
			if (!(immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)) {
				PrimogemcraftMod.queueServerWork((int) (!(immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.CHUNMEIZHIPAO.get())) : false) ? 10 : 20), () -> {
					entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
				});
			} else {
				if (immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.CHUNMEIZHIPAO.get())) : false) {
					PrimogemcraftMod.queueServerWork((int) ((immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8 ? 30 : 20), () -> {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
							});
				} else {
					PrimogemcraftMod.queueServerWork((int) ((immediatesourceentity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWYBTZDYPJ.get())) : false)
							&& (entity instanceof LivingEntity _livEnt ? _livEnt.getHealth() : -1) > (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 0.8 ? 20 : 10), () -> {
								entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC_KILL)), (float) entity.getPersistentData().getDouble("jiazu_shengjie_shuxing"));
							});
				}
			}
			if (immediatesourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JIAZUXIANZHI.get(), 20, 0, false, false));
		}
	}
}
