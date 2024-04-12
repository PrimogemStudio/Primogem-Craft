package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

import java.util.concurrent.atomic.AtomicReference;

@Mod.EventBusSubscriber
public class SmclstsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		execute(null, world, x, y, z, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			if (sourceentity instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PrimogemcraftModMobEffects.SMCLXG.get()) && !(entity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.SMCLZF.get()))
					&& entity instanceof LivingEntity _livEnt3 && _livEnt3.getMobType() == MobType.UNDEAD) {
				if (Math.random() <= 0.3) {
					{
						AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
						sourceentity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
						if (_iitemhandlerref.get() != null) {
							for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
								ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
								if (itemstackiterator.getItem() == PrimogemcraftModItems.QWSMCL.get()) {
									a = a + 1;
								}
							}
						}
					}
					if (a != 0) {
						sourceentity.getPersistentData().putBoolean("smcl_cf", true);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SMCLZF.get(), 80, 0, false, false));
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.PLAYERS, 1, 20);
							} else {
								_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.enchantment_table.use")), SoundSource.PLAYERS, 1, 20, false);
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(Items.GOLDEN_HELMET));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET));
							}
						}
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			}
		}
	}
}
