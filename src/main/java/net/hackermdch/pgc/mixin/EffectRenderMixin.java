package net.hackermdch.pgc.mixin;

import net.hacker.genshincraft.render.EffectRender;
import net.mcreator.ceshi.GenshinCraftLinkage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.lang.invoke.MethodHandles;

@Pseudo
@Mixin(EffectRender.class)
public class EffectRenderMixin {
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void init(CallbackInfo ci) {
        try {
            MethodHandles.lookup().ensureInitialized(GenshinCraftLinkage.class);
        } catch (Throwable ignore) {
        }
    }
}
