package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.function.Supplier;
import java.util.Map;

public class GUItishiProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = new ItemStack(PrimogemcraftModItems.KAIFAQIANGZHI_01.get());
				_setstack.setCount(1);
				((Slot) _slots.get(4)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}
