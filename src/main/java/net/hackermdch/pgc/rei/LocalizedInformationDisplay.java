package net.hackermdch.pgc.rei;

import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.plugin.common.displays.DefaultInformationDisplay;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LocalizedInformationDisplay extends DefaultInformationDisplay {
    private final Map<String, Information> information;
    private EntryIngredient entryStacks;
    private List<Component> texts;
    private String code;

    public LocalizedInformationDisplay(String name, Map<String, Information> infos) {
        super(null, Component.literal(name));
        information = infos;
    }

    private void update() {
        var lang = Minecraft.getInstance().getLanguageManager().getSelected();
        if (lang.equals(code)) return;
        code = lang;
        var builder = EntryIngredient.builder();
        var info = information.containsKey(lang) ? information.get(lang) : information.containsKey("en_us") ? information.get("en_us") : information.get("zh_cn");
        for (var s : info.items()) {
            if (s.startsWith("#"))
                builder.addAll(EntryIngredients.ofItemTag(ItemTags.create(ResourceLocation.parse(s.substring(1)))));
            else builder.add(EntryStacks.of(BuiltInRegistries.ITEM.get(ResourceLocation.parse(s))));
        }
        entryStacks = builder.build();
        texts = info.lines();
    }

    @Override
    public List<EntryIngredient> getInputEntries() {
        update();
        return Collections.singletonList(entryStacks);
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        update();
        return Collections.singletonList(entryStacks);
    }

    @Override
    public EntryIngredient getEntryStacks() {
        update();
        return entryStacks;
    }

    @Override
    public List<Component> getTexts() {
        update();
        return texts;
    }
}
