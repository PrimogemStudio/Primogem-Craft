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
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.concurrent.atomic.AtomicReference;

public class Qcmx_sxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack c = ItemStack.EMPTY;
		double a = 0;
		double b = 0;
		double s1 = 0;
		double s2 = 0;
		if (!world.isClientSide() && (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get())) : false)) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (!itemstack.getOrCreateTag().getBoolean("quchichushi")) {
				itemstack.getOrCreateTag().putBoolean("quchichushi", true);
				itemstack.getOrCreateTag().putDouble("quchi_sx", 60);
			}
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
			if (!entity.isShiftKeyDown()) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) a, _player.inventoryMenu.getCraftSlots());
				}
				if (a != 0) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) (itemstack.getOrCreateTag().getDouble("quchi_sx") * 20), (int) (a * (1 / 16.0) - 1), false, false));
					itemstack.getOrCreateTag().putDouble("quchi_sx", (itemstack.getOrCreateTag().getDouble("quchi_sx") - Math.floor(a * (1 / 16.0)) * 5));
					if (itemstack.getOrCreateTag().getDouble("quchi_sx") < 1) {
						c = itemstack;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = c;
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7f\u9F8B\u9F7F\u661F\u7CFB\u6A21\u578B\u00A7c\u5DF2\u635F\u574F\uFF01"), false);
					}
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A77\u6D88\u8017\u4E86\u6240\u6709\u5B87\u5B99\u788E\u7247\u6362\u53D6\u4E86\u529B\u91CF\u6548\u679C"), false);
			} else {
				b = Math.floor(itemstack.getOrCreateTag().getDouble("quchi_sx") * (1 / 60.0));
				if (a >= b) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) b, _player.inventoryMenu.getCraftSlots());
					}
					itemstack.getOrCreateTag().putDouble("quchi_sx", (itemstack.getOrCreateTag().getDouble("quchi_sx") + 1));
				}
			}
			itemstack
					.setHoverName(
							Component
									.literal(
											("\u00A75\u300E\u5947\u7269\u300F\u00A7f\u9F8B\u9F7F\u661F\u7CFB\u6A21\u578B"
													+ (itemstack.getOrCreateTag().getDouble("quchi_sx") < 1
															? "\u00A7c0s"
															: "" + (itemstack.getOrCreateTag().getDouble("quchi_sx") >= 60
																	? new java.text.DecimalFormat("\u00A7b##.m##").format(Math.floor(itemstack.getOrCreateTag().getDouble("quchi_sx") * (1 / 60.0))) + ""
																			+ new java.text.DecimalFormat("##.s##")
																					.format(itemstack.getOrCreateTag().getDouble("quchi_sx") - Math.floor(itemstack.getOrCreateTag().getDouble("quchi_sx") * (1 / 60.0)) * 60)
																	: new java.text.DecimalFormat("\u00A7b##.s##").format(itemstack.getOrCreateTag().getDouble("quchi_sx")))))));
		}
		DiaoyonghuishouProcedure.execute(entity, itemstack);
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format(itemstack.getOrCreateTag().getDouble("quchi_sx")))), false);
	}
}
