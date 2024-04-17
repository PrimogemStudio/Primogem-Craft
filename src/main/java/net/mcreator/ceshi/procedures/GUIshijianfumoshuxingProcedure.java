package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import java.util.function.Supplier;
import java.util.Map;

public class GUIshijianfumoshuxingProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).isEnchantable()
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).isEnchanted())
				&& entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") != 0
				&& !((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY).getItem() instanceof ShieldItem)) {
			a = ((EnchantmentHelper.enchantItem(RandomSource.create(),
					(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY),
					(int) (entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") * 10 + Mth.nextInt(RandomSource.create(), 1, 10)), false)).copy());
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = a.copy();
				_setstack.setCount(1);
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			entity.getPersistentData().putDouble("pgc_shijian_fumo_pinzhi", 0);
		}
	}
}
