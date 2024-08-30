
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(Registries.PAINTING_VARIANT, PrimogemcraftMod.MODID);
	public static final DeferredHolder<PaintingVariant, PaintingVariant> FULINNA = REGISTRY.register("fulinna", () -> new PaintingVariant(16, 16));
}
