package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.concurrent.atomic.AtomicReference;

public class QwlbtclsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack b = ItemStack.EMPTY;
		double a = 0;
		double c = 0;
		b = (new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()).copy());
		{
			AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
			entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
			if (_iitemhandlerref.get() != null) {
				for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
					ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
					if (itemstackiterator.getItem() == b.getItem()) {
						a = a + itemstackiterator.getCount();
					}
				}
			}
		}
		if (a >= 45 && !world.isClientSide()) {
			itemstack.getOrCreateTag().putDouble("lubotechilun", (itemstack.getOrCreateTag().getDouble("lubotechilun") + 1));
			if (itemstack.getOrCreateTag().getDouble("lubotechilun") >= 200) {
				itemstack.getOrCreateTag().putDouble("lubotechilun", 0);
				c = Math.round(Mth.nextInt(RandomSource.create(), 10, 20));
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component
							.literal((new java.text.DecimalFormat("\u00A75\u300E\u5947\u7269\u300F\u00A7e\u9C81\u4F2F\u7279\u5E1D\u56FD\u673A\u68B0\u9F7F\u8F6E\u00A77\u4E3A\u4F60\u5E26\u6765\u4E86\u00A7b##.\u00A75\u5B87\u5B99\u788E\u7247\uFF01##")
									.format(c))),
							false);
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get()).copy();
					_setstack.setCount((int) c);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				a = 0;
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == b.getItem()) {
								a = a + itemstackiterator.getCount();
							}
						}
					}
				}
				if (a > 64) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) a, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("\u00A75\u300E\u5947\u7269\u300F\u00A7e\u9C81\u4F2F\u7279\u5E1D\u56FD\u673A\u68B0\u9F7F\u8F6E\u00A7c\u89C9\u5F97\u4F60\u62E5\u6709\u7684\u592A\u591A\u4E86"), false);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, (float) 0.5);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, (float) 0.5, false);
						}
					}
					itemstack.shrink(1);
					for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 2); index0++) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z,
									new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("pgc:lbtjxclzlp"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
