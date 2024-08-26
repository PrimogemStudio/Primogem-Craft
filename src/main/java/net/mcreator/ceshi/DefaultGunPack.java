package net.mcreator.ceshi;

import com.tacz.guns.api.resource.ResourceManager;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DefaultGunPack {
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void init(FMLCommonSetupEvent event) {
        try {
            ResourceManager.registerExtraGunPack(DefaultGunPack.class, "/pgfs_default_gun");
        } catch (Throwable ignore) {
        }
    }
}
