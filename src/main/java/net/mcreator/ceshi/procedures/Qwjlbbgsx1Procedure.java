package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

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
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.concurrent.atomic.AtomicReference;

public class Qwjlbbgsx1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get())) : false) && !world.isClientSide()) {
			{
				AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
				entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
				if (_iitemhandlerref.get() != null) {
					for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
						ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
						if (itemstackiterator.getItem() == PrimogemcraftModItems.YUZHOUSUIPIAN.get()) {
							a = a + itemstackiterator.getCount();
						}
					}
				}
			}
			if (a >= 256 - itemstack.getOrCreateTag().getDouble("tcjlbbg_jishu")) {
				b = 256 - itemstack.getOrCreateTag().getDouble("tcjlbbg_jishu");
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) b, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) (b * 8));
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component
							.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7f\u5929\u624D\u4FF1\u4E50\u90E8\u666E\u901A\u516B\u5366\u00A7c\u8F6C\u5316\u4E86\u6240\u6709\u5B87\u5B99\u788E\u7247\uFF0C\u5E76\u9500\u6BC1\u4E86\u81EA\u8EAB\uFF01"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, (float) 0.5, false);
					}
				}
				itemstack.shrink(1);
				if (entity instanceof Player _player)
					_player.giveExperiencePoints(-((int) (DiaoyongjisuanjingyanzhiProcedure.execute(entity) * 0.5)));
			} else {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) a, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) (a * 8));
				itemstack.getOrCreateTag().putDouble("tcjlbbg_jishu", (itemstack.getOrCreateTag().getDouble("tcjlbbg_jishu") + a));
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7f\u5929\u624D\u4FF1\u4E50\u90E8\u666E\u901A\u516B\u5366\u00A76\u5C06\u5B87\u5B99\u788E\u7247\u8F6C\u5316\u4E3A\u4E86\u7ECF\u9A8C"), false);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, (float) 0.5);
					} else {
						_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.NEUTRAL, 1, (float) 0.5, false);
					}
				}
				itemstack.setHoverName(Component.literal(
						("\u00A75\u300E\u5947\u7269\u300F\u00A7f\u5929\u624D\u4FF1\u4E50\u90E8\u666E\u901A\u516B\u5366" + new java.text.DecimalFormat("\u00A7c##\u00A7b/\u00A7c256.##").format(itemstack.getOrCreateTag().getDouble("tcjlbbg_jishu")))));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(PrimogemcraftModMobEffects.QWJLBBGSX_2.get()))) {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QWJLBBGSX_2.get(), 60, 0, false, false));
		}
	}
}
