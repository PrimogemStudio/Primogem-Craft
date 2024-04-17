package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.nbt.CompoundTag;

import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.function.Supplier;
import java.util.Map;

public class GUIshijianfumoshuxingProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			PrimogemcraftMod.queueServerWork(1, () -> {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).isEnchantable()
						&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).isEnchanted())
						&& entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") != 0) {
					{
						CompoundTag _nbtTag = ((EnchantmentHelper.enchantItem(RandomSource.create(),
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY),
								(int) (entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") * Mth.nextInt(RandomSource.create(), 1, 10)), true)).copy()).getTag();
						if (_nbtTag != null)
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).setTag(_nbtTag.copy());
					}
					entity.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", 0);
				}
			});
		}
	}
}
