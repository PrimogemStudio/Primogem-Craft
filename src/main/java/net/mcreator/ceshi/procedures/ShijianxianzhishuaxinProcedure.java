package net.mcreator.ceshi.procedures;

import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ShijianxianzhishuaxinProcedure {
	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		execute(event, event.getLevel());
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (!world.isClientSide()) {
			if (Math.floor(world.dayTime() / 24000) != PrimogemcraftModVariables.MapVariables.get(world).jishiqi_meiri) {
				PrimogemcraftModVariables.MapVariables.get(world).jishiqi_meiri = Math.floor(world.dayTime() / 24000);
				PrimogemcraftModVariables.MapVariables.get(world).syncData(world);
				PrimogemcraftModVariables.MapVariables.get(world).shijian_xianzhi = 0;
				PrimogemcraftModVariables.MapVariables.get(world).syncData(world);
			}
		}
	}
}
