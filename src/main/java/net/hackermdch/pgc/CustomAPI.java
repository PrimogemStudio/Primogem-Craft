package net.hackermdch.pgc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModList;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class CustomAPI {
    public static final boolean GenshinCraftLoaded = ModList.get().isLoaded("genshincraft");
    static final Map<Item, CustomBar> defaults = new HashMap<>();

    public static CustomBar getCustomBar(ItemStack stack) {
        var bar = stack.get(CustomComponents.CUSTOM_BAR);
        if (defaults.get(stack.getItem()).equals(bar)) {
            bar = new CustomBar(bar.numerator, bar.denominator, bar.visible);
            stack.set(CustomComponents.CUSTOM_BAR, bar);
        }
        return bar;
    }

    public static boolean hasCustomBar(ItemStack stack) {
        return stack.has(CustomComponents.CUSTOM_BAR);
    }

    public static AttributeWrapper getAttributes(ItemStack stack) {
        return new AttributeWrapper(stack);
    }

    @OnlyIn(Dist.CLIENT)
    @Nullable
    private static ClientPacketListener connection() {
        if (Minecraft.getInstance().level != null) {
            return Minecraft.getInstance().level.connection;
        } else if (Minecraft.getInstance().getConnection() != null) {
            return Minecraft.getInstance().getConnection();
        } else if (Minecraft.getInstance().gameMode != null) {
            return Minecraft.getInstance().gameMode.connection;
        }
        return null;
    }

    @OnlyIn(Dist.CLIENT)
    public static RegistryAccess registryAccess() {
        return connection() instanceof ClientPacketListener c ? c.registryAccess() : RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY);
    }
}
