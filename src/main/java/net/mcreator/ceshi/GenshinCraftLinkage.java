package net.mcreator.ceshi;

import net.hacker.genshincraft.render.EffectRender;
import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class GenshinCraftLinkage {
    static {
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.JISHENG, 1);
        EffectRender.registerRenderEffect(PrimogemcraftModMobEffects.GONGJITISHENG, 1);
    }
}
