package net.mcreator.ceshi;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.LootTableLoadEvent;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.GAME)
public class PGCEventHandler {
    @SubscribeEvent
    protected static void onLootTableLoad(LootTableLoadEvent event) {
    }
}
