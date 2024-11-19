package net.hackermdch.pgc;

import net.hackermdch.pgc.command.Test;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID)
public class CustomCommands {
    @SubscribeEvent
    private static void onRegisterCommands(RegisterCommandsEvent event) {
        Test.register(event.getDispatcher());
    }
}
