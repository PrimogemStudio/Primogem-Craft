package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ShieldItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.function.Supplier;
import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class GUIshijianfumoshuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		ItemStack b = ItemStack.EMPTY;
		b = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		if (b.isEnchantable() && !b.isEnchanted() && entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") != 0 && !(b.getItem() instanceof ShieldItem)) {
			a = (EnchantmentHelper.enchantItem(RandomSource.create(), (b.copy()), (int) (entity.getPersistentData().getDouble("pgc_shijian_fumo_pinzhi") * 10 + Mth.nextInt(RandomSource.create(), 1, 10)), true));
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				ItemStack _setstack = a.copy();
				_setstack.setCount(1);
				((Slot) _slots.get(0)).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(4 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
				for (Entity entityiterator : _entfound) {
					if ((entityiterator instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == PrimogemcraftModItems.SH_JWUPIN.get()) {
						if (!entityiterator.level().isClientSide())
							entityiterator.discard();
					}
				}
			}
			entity.getPersistentData().putBoolean("pgc_shijian_fumo_pinzhi", false);
		}
	}
}
