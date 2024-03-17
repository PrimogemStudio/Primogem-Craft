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

public class DiguidaimashuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.isEnchanted()) {
			JinzhifumoProcedure.execute(world, x, y, z, entity, itemstack);
		}
		Luandaima_shuxingProcedure.execute(itemstack);
		NaijiuxianzhishuchuProcedure.execute(itemstack);
		if (entity.getPersistentData().getBoolean("daima6_naijiu")) {
			itemstack.setDamageValue((int) (itemstack.getDamageValue() - 1));
			NaijiuxianzhiProcedure.execute(itemstack);
			entity.getPersistentData().putBoolean("daima6_naijiu", false);
		}
		if (!itemstack.getOrCreateTag().getBoolean("daima6_yixiufu")) {
			if (!itemstack.getOrCreateTag().getBoolean("daishanchu") && !itemstack.getOrCreateTag().getBoolean("daima6_yixiufu") && itemstack.getDamageValue() == 0) {
				itemstack.getOrCreateTag().putBoolean("daima6_yixiufu", true);
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7b\u65E0\u9650\u9012\u5F52\u7684\u4EE3\u7801\u00A7a\u4FEE\u590D\u5B8C\u6210"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
					}
				}
			}
		} else {
			if (!(entity instanceof LivingEntity _livEnt20 && _livEnt20.hasEffect(PrimogemcraftModMobEffects.DIGUIXIAOGUO.get()))) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.DIGUIXIAOGUO.get(), 100, 0, false, false));
				NaijiuxianzhiProcedure.execute(itemstack);
			}
		}
	}
}
