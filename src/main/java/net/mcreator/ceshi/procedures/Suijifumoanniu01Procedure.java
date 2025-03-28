package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.function.Supplier;
import java.util.Map;

public class Suijifumoanniu01Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (getAmountInGUISlot(entity, 0) >= 1 && (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).isEnchantable()
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY).isEnchanted())
				&& getAmountInGUISlot(entity, 1) >= 10) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, (float) 0.5, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.enchantment_table.use")), SoundSource.PLAYERS, (float) 0.5, 1, false);
				}
			}
			if (getAmountInGUISlot(entity, 0) == 1 && getAmountInGUISlot(entity, 1) >= 10 || getAmountInGUISlot(entity, 0) >= 1 && getAmountInGUISlot(entity, 1) < 20 && getAmountInGUISlot(entity, 1) >= 10) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(),
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY),
							Mth.nextInt(RandomSource.create(), 3, 9),
							(true)
									? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
									: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
							.copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(2)).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWXYZQ.get())) : false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(8);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(10);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
			if (getAmountInGUISlot(entity, 0) == 2 && getAmountInGUISlot(entity, 1) >= 20 || getAmountInGUISlot(entity, 0) >= 2 && getAmountInGUISlot(entity, 1) < 30 && getAmountInGUISlot(entity, 1) >= 20) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(),
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY),
							Mth.nextInt(RandomSource.create(), 7, 17),
							(true)
									? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
									: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
							.copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(2)).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(2);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWXYZQ.get())) : false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(16);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(20);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
			if (getAmountInGUISlot(entity, 0) >= 3 && getAmountInGUISlot(entity, 1) >= 30) {
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					ItemStack _setstack = (EnchantmentHelper.enchantItem(world.getRandom(),
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(2)).getItem() : ItemStack.EMPTY), 30,
							(true)
									? world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).holders().map(reference -> (Holder<Enchantment>) reference)
									: world.registryAccess().registryOrThrow(Registries.ENCHANTMENT).getTag(EnchantmentTags.IN_ENCHANTING_TABLE).get().stream()))
							.copy();
					_setstack.setCount(1);
					((Slot) _slots.get(3)).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(2)).set(ItemStack.EMPTY);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
					((Slot) _slots.get(0)).remove(3);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.QWXYZQ.get())) : false) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(24);
						_player.containerMenu.broadcastChanges();
					}
				} else {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						((Slot) _slots.get(1)).remove(30);
						_player.containerMenu.broadcastChanges();
					}
				}
			}
		}
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
