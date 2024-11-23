package net.hackermdch.pgc.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;
import static net.mcreator.ceshi.init.PrimogemcraftModEntities.*;
import static net.mcreator.ceshi.init.PrimogemcraftModItems.*;

@REIPluginClient
public class PGCClientPlugin implements REIClientPlugin {
    static final CategoryIdentifier<WishDisplay> WISH = CategoryIdentifier.of(MODID, "plugins/wish");
    static final CategoryIdentifier<ForgeDisplay> FORGE = CategoryIdentifier.of(MODID, "plugins/forge");

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new WishCategory(), new ForgeCategory());
        registry.addWorkstations(WISH, EntryStacks.of(XIXIANGYUZHIYUAN), EntryStacks.of(JIJIUCHANZHIYUAN), EntryStacks.of(SHILIANCHOU), EntryStacks.of(QYHX_0WUJIACHENG), EntryStacks.of(QYHXSHILIAN));
        registry.addWorkstations(FORGE, EntryStacks.of(HUALIDUANZAO));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(new WishDisplay(QQ_QYUANCHULAN_01.get(), ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "r"))));
        registry.add(new WishDisplay(Q_QYUANCHUZI_01.get(), ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "sr"))));
        registry.add(new WishDisplay(QQIYUAN_JIN_GUANG.get(), ItemTags.create(ResourceLocation.fromNamespaceAndPath("pgc", "ssr"))));
        registry.add(new ForgeDisplay());
    }
}
