package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import net.hackermdch.pgc.network.WishInfoPacket;

import static net.hackermdch.pgc.rei.PGCPlugin.WISH;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.JIJIUCHANZHIYUAN;

@REIPluginClient
public class PGCClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new WishCategory());
        registry.addWorkstations(WISH, EntryStacks.of(JIJIUCHANZHIYUAN));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(new WishDisplay(ImmutableList.of(EntryIngredients.of(JIJIUCHANZHIYUAN)), ImmutableList.of(EntryIngredients.ofItems(WishInfoPacket.info[0]))));
        registry.add(new WishDisplay(ImmutableList.of(EntryIngredients.of(JIJIUCHANZHIYUAN)), ImmutableList.of(EntryIngredients.ofItems(WishInfoPacket.info[1]))));
        registry.add(new WishDisplay(ImmutableList.of(EntryIngredients.of(JIJIUCHANZHIYUAN)), ImmutableList.of(EntryIngredients.ofItems(WishInfoPacket.info[2]))));
    }
}
