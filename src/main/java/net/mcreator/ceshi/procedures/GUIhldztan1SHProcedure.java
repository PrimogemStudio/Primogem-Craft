package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import java.util.function.Supplier;
import java.util.Map;

public class GUIhldztan1SHProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item, double deng_ji, double fanwei_0, double fanwei_1, double wei_zhi) {
		if (entity == null)
			return false;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!world.isClientSide()) {
			a = getAmountInGUISlot(entity, (int) wei_zhi);
			b = deng_ji - item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			a = a > b ? b : a;
			{
				final String _tagName = "deng_ji";
				final double _tagValue = (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + a);
				CustomData.update(DataComponents.CUSTOM_DATA, item, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get((int) wei_zhi)).remove((int) (a - a * Mth.nextDouble(RandomSource.create(), fanwei_0, fanwei_1)));
				_player.containerMenu.broadcastChanges();
			}
			return WuqishuaxinProcedure.execute(world, entity, item);
		}
		return false;
	}

	private static int getAmountInGUISlot(Entity entity, int sltid) {
		if (entity instanceof Player player && player.containerMenu instanceof Supplier slotSupplier && slotSupplier.get() instanceof Map guiSlots) {
			ItemStack stack = ((Slot) guiSlots.get(sltid)).getItem();
			if (stack != null)
				return stack.getCount();
		}
		return 0;
	}
}
