package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

public class Ceshi_3Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double ceshi_01 = 0;
		double a = 0;
		if (entity.isShiftKeyDown()) {
			{
				ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				_ist.hurtAndBreak(20, RandomSource.create(), null, () -> {
					_ist.shrink(1);
					_ist.setDamageValue(0);
				});
			}
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((BuiltInRegistries.ITEM.getKey((new Object() {
					public ItemStack getItemStack(int sltid, Entity entity) {
						if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandler) {
							return _modHandler.getStackInSlot(sltid).copy();
						}
						return ItemStack.EMPTY;
					}
				}.getItemStack(0, entity)).getItem()).toString())), false);
		}
	}
}
