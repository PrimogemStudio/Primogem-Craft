package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;
import java.util.Comparator;

public class Yiyijieguoshi_shuxingProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (YimuguoshisxhsProcedure.execute(world, x, y, z, entity, itemstack, itemstack, false, itemstack.getItem() == PrimogemcraftModItems.QWKWZG.get() ? false : true, 5, 1200, 2)) {
			if (itemstack.getItem() == PrimogemcraftModItems.QWYPZGS.get()) {
				entity.getPersistentData().putBoolean("ypz_ymgs", true);
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QWXXGG.get()) {
				entity.getPersistentData().putBoolean("qw_xxgg_sx", true);
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QWZCGS.get()) {
				{
					final Vec3 _center = new Vec3(x, y, z);
					List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(16 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
					for (Entity entityiterator : _entfound) {
						if (!(entityiterator == entity) && (entityiterator instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * 2) {
							if (!(entityiterator instanceof LivingEntity _livEnt15 && _livEnt15.hasEffect(PrimogemcraftModMobEffects.JISHENG))) {
								if (entityiterator instanceof LivingEntity _entity && !_entity.level().isClientSide())
									_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.JISHENG, 400, 4));
							}
						}
					}
				}
			}
		}
	}
}
