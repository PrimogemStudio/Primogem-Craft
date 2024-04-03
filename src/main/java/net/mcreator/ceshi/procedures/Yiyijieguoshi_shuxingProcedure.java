package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.PrimogemcraftMod;

public class Yiyijieguoshi_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.getPersistentData().getBoolean("yijieguoshi_kaiqi")) {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(1, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			PrimogemcraftMod.queueServerWork(10, () -> {
				if (world.isClientSide())
					Minecraft.getInstance().gameRenderer.displayItemActivation(itemstack);
			});
			entity.getPersistentData().putBoolean("yijieguoshi_kaiqi", false);
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.LINZHONG.get(), 1200, 0));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 1200, 9));
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2));
			if (itemstack.getDamageValue() == itemstack.getMaxDamage()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 3, (float) 0.6, false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A76\u5F02\u6728\u679C\u5B9E\u00A7c\u5DF2\u635F\u574F\uFF01"), true);
			}
		}
		if (!(entity instanceof LivingEntity _livEnt16 && _livEnt16.hasEffect(PrimogemcraftModMobEffects.QWYMGS.get())) && !(entity instanceof LivingEntity _livEnt17 && _livEnt17.hasEffect(PrimogemcraftModMobEffects.LINZHONG.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QWYMGS.get(), 20, 0));
		}
	}
}
