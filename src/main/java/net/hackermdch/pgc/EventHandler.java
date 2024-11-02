package net.hackermdch.pgc;

import net.mcreator.ceshi.CustomBarRegister;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
public class EventHandler {
    @OnlyIn(Dist.CLIENT)
    @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class Client {
        @SubscribeEvent
        private static void onRegisterItemDecorations(RegisterItemDecorationsEvent event) {
            CustomBarRegister.registers.forEach(it -> event.register(it.item(), it.decorator()));
        }
    }

    @SubscribeEvent
    private static void onModifyDefaultComponents(ModifyDefaultComponentsEvent event) {
        CustomBarRegister.registers.forEach(it -> {
            event.modify(it.item(), builder -> builder.set(CustomComponents.CUSTOM_BAR, it.component()));
            CustomAPI.defaults.put(it.item().asItem(), it.component());
        });
    }
}
