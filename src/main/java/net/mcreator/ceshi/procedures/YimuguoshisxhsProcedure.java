package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class YimuguoshisxhsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, ItemStack itemstack, boolean itemi, boolean sunhuai, double mian_shang, double shijian, double sudu_dengji) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		ItemStack item1 = ItemStack.EMPTY;
		if (entity.getPersistentData().getBoolean("yijieguoshi_kaiqi")) {
			if (sunhuai) {
				if (itemstack.getDamageValue() == itemstack.getMaxDamage() - 1) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((itemstack.getDisplayName().getString() + "\u00A7c\u5DF2\u635F\u574F\uFF01")), false);
					itemstack.shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6, false);
						}
					}
				} else {
					{
						ItemStack _ist = itemstack;
						_ist.hurtAndBreak(1, RandomSource.create(), null, () -> {
							_ist.shrink(1);
							_ist.setDamageValue(0);
						});
					}
				}
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			entity.getPersistentData().putBoolean("yijieguoshi_kaiqi", false);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.LINZHONG, (int) shijian, (int) mian_shang));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, (int) shijian, 9));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) shijian, (int) sudu_dengji));
			if (itemi) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, item);
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
			}
		}
		if (itemstack.isEnchanted()) {
			item1 = itemstack;
			EnchantmentHelper.setEnchantments(item1, ItemEnchantments.EMPTY);
		}
		if (!(entity instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(PrimogemcraftModMobEffects.QWYMGS)) && !(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(PrimogemcraftModMobEffects.LINZHONG))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QWYMGS, 20, 0));
		}
	}
}
