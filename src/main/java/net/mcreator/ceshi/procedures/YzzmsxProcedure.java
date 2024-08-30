package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModEnchantments;

public class YzzmsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).isEnchanted()) {
				if (Math.random() < 0.25) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7c\u611A\u8005\u4E4B\u9762\u00A77\u5DF2\u6D88\u8017\uFF01\u00A75\u6C38\u4E0D\u6CAE\u4E27\uFF01"), false);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).applyComponents(
							(EnchantmentHelper.enchantItem(FeatureFlagSet.of(FeatureFlags.VANILLA), RandomSource.create(), ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy()), 30, false)).getComponents());
					itemstack.shrink(1);
				} else if (Math.random() < 0.25) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7c\u611A\u8005\u4E4B\u9762\u00A77\u5DF2\u6D88\u8017\uFF01\u00A7b\u6C38\u4E0D\u6B3A\u9A97\uFF01"), false);
					if (entity instanceof LivingEntity _entity) {
						ItemStack _setstack = new ItemStack(Items.BOOK).copy();
						_setstack.setCount(1);
						_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
						if (_entity instanceof Player _player)
							_player.getInventory().setChanged();
					}
					(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).applyComponents((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getComponents());
				} else if (Math.random() < 0.25) {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7c\u611A\u8005\u4E4B\u9762\u00A77\u5DF2\u6D88\u8017\uFF01\u00A7e\u6C38\u4E0D\u629B\u5F03\uFF01"), false);
					a = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getEnchantmentLevel(PrimogemcraftModEnchantments.FUMOYUZHEZN.get());
					EnchantmentHelper.updateEnchantments((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY),
							mutableEnchantments -> mutableEnchantments.removeIf(enchantment -> enchantment.value() == PrimogemcraftModEnchantments.FUMOYUZHEZN.get()));
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).enchant(PrimogemcraftModEnchantments.FUMOYUZHEZN.get(), (int) (a + 1));
					itemstack.shrink(1);
				} else {
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7c\u611A\u8005\u4E4B\u9762\u00A77\u5DF2\u6D88\u8017\uFF01\u00A72\u6C38\u4E0D\u4F24\u5BB3\uFF01"), false);
					(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).setDamageValue((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getMaxDamage() - 1));
					itemstack.shrink(1);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}
