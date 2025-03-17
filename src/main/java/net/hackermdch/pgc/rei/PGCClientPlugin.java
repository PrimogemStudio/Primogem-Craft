package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import me.shedaniel.rei.RoughlyEnoughItemsCoreClient;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.plugins.PluginManager;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import me.shedaniel.rei.plugin.client.BuiltinClientPlugin;
import net.hackermdch.pgc.network.WishInfoPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
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
    private static Multimap<String, Information> information = ImmutableMultimap.of();
    private static final Map<String, Map<String, Information>> byName = new HashMap<>();
    private static final List<String> allInfos = new ArrayList<>();

    @SuppressWarnings("UnstableApiUsage")
    public static void updateInfo(List<Information> list) {
        var builder = ImmutableMultimap.<String, Information>builder();
        allInfos.clear();
        byName.clear();
        for (var it : list) {
            builder.put(it.code(), it);
            if (!allInfos.contains(it.name()) && (it.code().equals("zh_cn") || it.code().equals("en_us")))
                allInfos.add(it.name());
        }
        information = builder.build();
        for (var it : information.keys()) {
            if (!byName.containsKey(it)) byName.put(it, new HashMap<>());
            var infos = information.get(it);
            var map = byName.get(it);
            for (var info : infos) map.put(info.name(), info);
        }
        if (!PluginManager.getClientInstance().isReloading()) RoughlyEnoughItemsCoreClient.reloadPlugins(null, null);
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
        var code = Minecraft.getInstance().getLanguageManager().getSelected();
        var infos = information.get(code);
        var replaced = new ArrayList<String>();
        for (var it : infos) {
            addInformation(it);
            replaced.add(it.name());
        }
        for (var it : allInfos) {
            if (replaced.contains(it)) continue;
            var info = byName.get("en_us").get(it);
            if (info != null) {
                addInformation(info);
                continue;
            }
            info = byName.get("zh_cn").get(it);
            if (info != null) addInformation(info);
        }
    }

    private void addInformation(Information info) {
        var builder = EntryIngredient.builder();
        for (var s : info.items()) {
            if (s.startsWith("#"))
                builder.addAll(EntryIngredients.ofItemTag(ItemTags.create(ResourceLocation.parse(s.substring(1)))));
            else builder.add(EntryStacks.of(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s))));
        }
        BuiltinClientPlugin.getInstance().registerInformation(builder.build(), Component.literal(info.name()), list -> {
            list.addAll(info.lines());
            return list;
        });
    }

    private void addWishEntry(DisplayRegistry registry, EntityType<? extends LivingEntity> type, Set<ItemLike> items) {
        for (var item : items) {
            registry.add(new WishDisplay(type, ImmutableList.of(EntryIngredients.of(item))));
        }
    }
}
