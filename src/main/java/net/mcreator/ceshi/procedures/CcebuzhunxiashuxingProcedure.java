package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class CcebuzhunxiashuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.CEBUZHUNXIA.get()
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.CEBUZHUNXIA.get())) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isEnchantable()) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isEnchanted()) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u300E\u5947\u7269\u300F\u00A7e\u6D4B\u4E0D\u51C6\u5323\u00A7c\u65E0\u6CD5\u5E72\u6D89"), false);
				} else {
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).shrink(1);
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PrimogemcraftModItems.SHCBZX.get());
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1, false);
						}
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7e\u6D4B\u4E0D\u51C6\u5323\u00A7c\u5DF2\u6D88\u8017"), true);
					if (Math.random() < 0.1) {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), (int) Mth.nextDouble(RandomSource.create(), 10, 30),
									true));
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					} else {
						if (entity instanceof LivingEntity _entity) {
							ItemStack _setstack = (EnchantmentHelper.enchantItem(RandomSource.create(), (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), (int) Mth.nextDouble(RandomSource.create(), 1, 13), true));
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u300E\u5947\u7269\u300F\u00A7e\u6D4B\u4E0D\u51C6\u5323\u00A7c\u7231\u83AB\u80FD\u52A9"), false);
			}
		}
	}
}
