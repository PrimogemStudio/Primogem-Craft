package net.hackermdch.pgc.rei;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REIServerPlugin;
import me.shedaniel.rei.forge.REIPluginCommon;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@REIPluginCommon
public class PGCPlugin implements REIServerPlugin {
    static final CategoryIdentifier<WishDisplay> WISH = CategoryIdentifier.of(MODID, "plugins/wish");
    static final CategoryIdentifier<ForgeDisplay> FORGE = CategoryIdentifier.of(MODID, "plugins/forge");

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(WISH, WishDisplay.serializer());
    }
}
