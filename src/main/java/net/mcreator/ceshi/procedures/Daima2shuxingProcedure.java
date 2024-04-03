package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class Daima2shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		JinzhifumoProcedure.execute(world, x, y, z, entity, itemstack);
		Luandaima_shuxingProcedure.execute(itemstack);
		NaijiuxianzhishuchuProcedure.execute(itemstack);
		if (entity.getPersistentData().getBoolean("daima2_naijiu")) {
			itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
			NaijiuxianzhiProcedure.execute(itemstack);
			entity.getPersistentData().putBoolean("daima2_naijiu", false);
		}
		if (!itemstack.getOrCreateTag().getBoolean("daishanchu") && !itemstack.getOrCreateTag().getBoolean("daima2_yixiufu") && itemstack.getDamageValue() == 0) {
			itemstack.getOrCreateTag().putBoolean("daima2_yixiufu", true);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A79\u6709\u70B9\u8E4A\u8DF7\u7684\u4EE3\u7801\u00A7a\u4FEE\u590D\u5B8C\u6210"), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
		}
		if (itemstack.getOrCreateTag().getBoolean("daima2_yixiufu")) {
			if (!(entity instanceof LivingEntity _livEnt18 && _livEnt18.hasEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU.get(), 200, 0, false, false));
				NaijiuxianzhiProcedure.execute(itemstack);
			}
		}
	}
}
