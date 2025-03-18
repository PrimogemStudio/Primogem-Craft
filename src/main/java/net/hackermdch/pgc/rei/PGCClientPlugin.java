package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import net.hackermdch.pgc.network.WishInfoPacket;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.ItemLike;

import java.util.*;

import static net.hackermdch.pgc.rei.PGCPlugin.FORGE;
import static net.hackermdch.pgc.rei.PGCPlugin.WISH;
import static net.mcreator.ceshi.init.PrimogemcraftModEntities.*;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.*;

@REIPluginClient
public class PGCClientPlugin implements REIClientPlugin {
    private static final List<LocalizedInformationDisplay> displays = new ArrayList<>();

    static void updateInfo(List<Information> list) {
        var multimap = new HashMap<String, Map<String, Information>>();
        for (var it : list) {
            if (!multimap.containsKey(it.name())) multimap.put(it.name(), new HashMap<>());
            var map = multimap.get(it.name());
            map.put(it.code(), it);
        }
        displays.clear();
        for (var it : multimap.entrySet())
            if (it.getValue().containsKey("en_us") || it.getValue().containsKey("zh_cn"))
                displays.add(new LocalizedInformationDisplay(it.getKey(), it.getValue()));
    }

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new WishCategory(), new ForgeCategory());
        registry.addWorkstations(WISH, EntryStacks.of(XIXIANGYUZHIYUAN), EntryStacks.of(JIJIUCHANZHIYUAN), EntryStacks.of(SHILIANCHOU), EntryStacks.of(QYHX_0WUJIACHENG), EntryStacks.of(QYHXSHILIAN));
        registry.addWorkstations(FORGE, EntryStacks.of(HUALIDUANZAO));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        addWishEntry(registry, QQ_QYUANCHULAN_01.get(), WishInfoPacket.info[0]);
        addWishEntry(registry, Q_QYUANCHUZI_01.get(), WishInfoPacket.info[1]);
        addWishEntry(registry, QQIYUAN_JIN_GUANG.get(), WishInfoPacket.info[2]);
        registry.add(new ForgeDisplay());
        displays.forEach(registry::add);
    }

    private void addWishEntry(DisplayRegistry registry, EntityType<? extends LivingEntity> type, Set<ItemLike> items) {
        for (var item : items) {
            registry.add(new WishDisplay(type, ImmutableList.of(EntryIngredients.of(item))));
        }
    }
}
