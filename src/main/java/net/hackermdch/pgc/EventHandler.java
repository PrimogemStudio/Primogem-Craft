package net.hackermdch.pgc;

import com.google.common.collect.ImmutableList;
import net.hackermdch.pgc.network.ParticlePacket;
import net.hackermdch.pgc.network.WishInfoConfiguration;
import net.hackermdch.pgc.network.WishInfoPacket;
import net.hackermdch.pgc.rei.Information;
import net.hackermdch.pgc.rei.PGCClientPlugin;
import net.mcreator.ceshi.CustomBarRegister;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterItemDecorationsEvent;
import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.network.event.RegisterConfigurationTasksEvent;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;

import java.io.IOException;
import java.util.Arrays;

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
    private static void register(RegisterConfigurationTasksEvent event) {
        if (ModList.get().isLoaded("roughlyenoughitems")) {
            event.register(new WishInfoConfiguration(event.getListener()));
        }
    }

    @SubscribeEvent
    private static void onRegisterClientReloadListeners(RegisterClientReloadListenersEvent event) {
        if (!ModList.get().isLoaded("roughlyenoughitems")) return;
        event.registerReloadListener((ResourceManagerReloadListener) (resourceManager) -> {
            var infos = resourceManager.listResources("rei_info", id -> id.getPath().endsWith(".txt"));
            var builder = ImmutableList.<Information>builder();
            for (var it : infos.entrySet()) {
                try (var br = it.getValue().openAsReader()) {
                    var lines = br.lines().toList();
                    var items = Arrays.stream(lines.getFirst().split(",")).map(String::trim).toList();
                    var components = ImmutableList.<Component>builder();
                    for (int i = 1; i < lines.size(); i++) components.add(Component.literal(lines.get(i)));
                    var path = it.getKey().getPath();
                    path = path.substring(path.indexOf('/') + 1);
                    var code = path.substring(0, path.indexOf('/'));
                    path = path.substring(path.indexOf('/') + 1);
                    path = path.substring(0, path.lastIndexOf('.'));
                    builder.add(new Information(code, it.getKey().withPath(path).toString(), items, components.build()));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            PGCClientPlugin.updateInfo(builder.build());
        });
    }
}
