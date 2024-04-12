package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class SmclsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.SMCLXG.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SMCLXG.get(), 80, 0, false, false));
		}
		if (entity.getPersistentData().getBoolean("smcl_cf")) {
			entity.getPersistentData().putBoolean("smcl_cf", false);
			itemstack.getOrCreateTag().putDouble("smcl_sx", (itemstack.getOrCreateTag().getDouble("smcl_sx") + 1));
		}
		if (itemstack.getOrCreateTag().getDouble("smcl_sx") < 5) {
			itemstack.setDamageValue((int) itemstack.getOrCreateTag().getDouble("smcl_sx"));
		} else {
			{
				ItemStack _ist = itemstack;
				if (_ist.hurt(100, RandomSource.create(), null)) {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7d\u300C\u795E\u79D8\u300D\u78C1\u529B\u00A7c\u5DF2\u635F\u574F\uFF01"), false);
		}
	}
}
