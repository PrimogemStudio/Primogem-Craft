package net.mcreator.ceshi;

import com.tacz.guns.api.resource.ResourceManager;

public class DefaultGunPack {
    static void register() {
        try {
            ResourceManager.registerExtraGunPack(DefaultGunPack.class, "/pgfs_default_gun");
        } catch (Throwable ignore) {
        }
    }
}
