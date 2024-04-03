
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.entity.decoration.PaintingVariant;

import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModPaintings {
	public static final DeferredRegister<PaintingVariant> REGISTRY = DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, PrimogemcraftMod.MODID);
	public static final RegistryObject<PaintingVariant> FULINNA = REGISTRY.register("fulinna", () -> new PaintingVariant(16, 16));
}
