package net.mcreator.ceshi.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ShijianxianzhishuaxinProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
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
