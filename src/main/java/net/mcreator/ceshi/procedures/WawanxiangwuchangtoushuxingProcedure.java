package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

public class WawanxiangwuchangtoushuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isEnchanted()
				&& !((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("wanxiangtou_xianzhi"))) {
			{
				CompoundTag _nbtTag = (EnchantmentHelper.enchantItem(RandomSource.create(), ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy()), 30, false)).getTag();
				if (_nbtTag != null)
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setTag(_nbtTag.copy());
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putBoolean("wanxiangtou_xianzhi", true);
			itemstack.shrink(1);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 5, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(itemstack.getItem(), 20);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A75\u7CFB\u7EDF\uFF1A\u300E\u5947\u7269\u300F\u00A72\u4E07\u8C61\u65E0\u5E38\u9AB0\u00A7c\u5DF2\u6D88\u8017"), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("wanxiangtou_xianzhi")
						? "\u00A77\u8BE5\u88C5\u5907\u5DF2\u4F7F\u7528\u8FC7\u00A7c\u4E07\u8C61\u65E0\u5E38\u9AB0\uFF01"
						: "\u00A75\u7CFB\u7EDF\uFF1A\u300E\u5947\u7269\u300F\u00A72\u4E07\u8C61\u65E0\u5E38\u9AB0\u00A7c\u4E00\u8138\u61F5\u54D4\u54E9")), false);
		}
	}
}
