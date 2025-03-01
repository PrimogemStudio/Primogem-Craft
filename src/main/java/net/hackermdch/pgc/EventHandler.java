package net.hackermdch.pgc;

import net.hackermdch.pgc.network.ParticlePacket;
import net.hackermdch.pgc.network.WishInfoConfiguration;
import net.hackermdch.pgc.network.WishInfoPacket;
import net.mcreator.ceshi.CustomBarRegister;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.network.event.RegisterConfigurationTasksEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @SubscribeEvent
    private static void onRegisterItemDecorations(RegisterItemDecorationsEvent event) {
        CustomBarRegister.registers.forEach(it -> event.register(it.item(), it.decorator()));
    }

    @SubscribeEvent
    private static void onModifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        CustomBarRegister.registers.forEach(it -> {
            event.modify(it.item(), builder -> builder.set(CustomComponents.CUSTOM_BAR, it.component()));
            CustomAPI.defaults.put(it.item().asItem(), it.component());
        });
    }

    @SubscribeEvent
    private static void registerNetworking(RegisterPayloadHandlersEvent event) {
        var registrar = event.registrar(MODID);
        ParticlePacket.register(registrar);
        if (ModList.get().isLoaded("roughlyenoughitems")) {
            WishInfoPacket.register(registrar);
        }
    }

    @SubscribeEvent
    public static void register(RegisterConfigurationTasksEvent event) {
        if (ModList.get().isLoaded("roughlyenoughitems")) {
            event.register(new WishInfoConfiguration(event.getListener()));
        }
    }
}
