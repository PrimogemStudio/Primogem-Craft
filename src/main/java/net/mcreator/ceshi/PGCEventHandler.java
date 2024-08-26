package net.mcreator.ceshi;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.minecraft.world.level.storage.loot.LootDataType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PGCEventHandler {
    private static List<LootPool> getPools(LootTable table) {
        try {
            var fs = table.getClass().getDeclaredFields();
            for (var f : fs) {
                if (f.getName().equals("f_79109_") || f.getName().equals("pools")) {
                    f.setAccessible(true);
                    return (List<LootPool>) f.get(table);
                }
            }
            throw new RuntimeException("No such field f_79109_");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SubscribeEvent
    protected static void onLoadLootTable(LootTableLoadEvent event) throws IOException {
        var loot = event.getTable();
        if (loot.getParamSet() == LootContextParamSets.CHEST) {
            try (var in = new InputStreamReader(Objects.requireNonNull(PGCEventHandler.class.getResourceAsStream("/data/primogemcraft/loot_tables/custominject.json")))) {
                var inject = ForgeHooks.loadLootTable(LootDataType.TABLE.parser(), event.getTable().getLootTableId(), new Gson().fromJson(in, JsonElement.class), true);
                var pools = getPools(inject);
                pools.forEach(loot::addPool);
                pools.clear();
            }
        }
    }
}
