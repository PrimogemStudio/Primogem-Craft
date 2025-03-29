package net.hackermdch.pgc;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.BlockPos;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.capabilities.Capabilities.ItemHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import org.jetbrains.annotations.Nullable;
import oshi.util.tuples.Pair;

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

    public static Pair<StardustConverterRecipe.Data, StardustConverterRecipe.Data> findConvertRecipe(LevelAccessor level, double x, double y, double z) {
        StardustConverterRecipe.Data r1 = null, r2 = null;
        if (level.getServer() != null) {
            if (level instanceof ILevelExtension ext) {
                var inv = ext.getCapability(ItemHandler.BLOCK, new BlockPos((int) x, (int) y, ((int) z)), null);
                if (inv != null) {
                    var item1 = inv.getStackInSlot(1);
                    var item2 = inv.getStackInSlot(3);
                    var recipes = level.getServer().getRecipeManager().getAllRecipesFor(CustomRegister.STARDUST_CONVERTER.get());
                    for (var r : recipes) {
                        var data = r.value().match(item1);
                        if (data != null) {
                            if (r1 == null) r1 = data;
                        } else {
                            data = r.value().match(item2);
                            if (data != null) {
                                if (r2 == null) r2 = data;
                            }
                        }
                        if (r1 != null && r2 != null) break;
                    }
                }
            }
        }
        return new Pair<>(r1, r2);
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
