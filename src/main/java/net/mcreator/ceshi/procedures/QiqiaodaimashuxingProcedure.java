package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.PrimogemcraftMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class QiqiaodaimashuxingProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		execute(null, world, x, y, z, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity sourceentity) {
		if (sourceentity == null)
			return;
		double n1 = 0;
		double n2 = 0;
		double nx1 = 0;
		double nx2 = 0;
		double ns = 0;
		double p = 0;
		if (sourceentity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
			for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
				ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
				if (itemstackiterator.getItem() == PrimogemcraftModItems.YOUDIANQIQIAODEDAIMA.get()) {
					if (sourceentity instanceof LivingEntity _livEnt2 && _livEnt2.hasEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU)) {
						ns = 10;
						n1 = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU) ? _livEnt.getEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU).getAmplifier() : 0;
						n2 = sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU) ? _livEnt.getEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU).getDuration() : 0;
						nx1 = n1 == 0 ? 1 : n1 + 1;
						nx2 = n2 + 400;
					} else {
						nx1 = 0;
						nx2 = 400;
					}
					for (Entity entityiterator : world.getEntities(sourceentity, new AABB((x + 8), (y + 8), (z + 8), (x - 8), (y - 8), (z - 8)))) {
						if (entityiterator instanceof Player) {
							p = p + 1;
							PrimogemcraftMod.LOGGER.info(p);
						}
					}
					ns = ns + ns * (p >= 3 ? 3 : p);
					if (sourceentity instanceof LivingEntity _entity)
						_entity.removeEffect(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU);
					if (sourceentity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.QIQIAODAIMAXIUFU, (int) nx2, (int) (nx1 >= ns ? ns - 1 : nx1), false, false));
				}
			}
		}
	}
}
