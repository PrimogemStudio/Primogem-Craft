package net.hackermdch.mixin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mojang.serialization.DynamicOps;
import net.mcreator.ceshi.PGCEventHandler;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootDataType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Optional;

@Mixin(LootDataType.class)
public class LootDataTypeMixin<T> {
    @Unique
    private static final ResourceLocation LOOT_TYPE = new ResourceLocation("minecraft", "chest");

    @Inject(method = "deserialize", at = @At("HEAD"))
    private <V> void deserialize(ResourceLocation res, DynamicOps<V> ops, V value, CallbackInfoReturnable<Optional<T>> cir) throws IOException {
        if (value instanceof JsonElement element) {
            if (LOOT_TYPE.equals(ResourceLocation.tryParse(element.getAsJsonObject().get("type").getAsString()))) {
                try (var in = new InputStreamReader(Objects.requireNonNull(PGCEventHandler.class.getResourceAsStream("/data/primogemcraft/loot_tables/custominject.json")))) {
                    var inject = new Gson().fromJson(in, JsonElement.class);
                    var ori = element.getAsJsonObject().get("pools");
                    if (ori != null) {
                        var pools = inject.getAsJsonObject().get("pools").getAsJsonArray();
                        element.getAsJsonObject().get("pools").getAsJsonArray().addAll(pools);
                    }
                }
            }
        }
    }
}
