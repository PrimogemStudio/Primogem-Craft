
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.core.registries.Registries;

import net.mcreator.ceshi.enchantment.FumoyuzheznEnchantment;
import net.mcreator.ceshi.enchantment.FmyuzhousuipianEnchantment;
import net.mcreator.ceshi.enchantment.Ceshifumo01Enchantment;
import net.mcreator.ceshi.PrimogemcraftMod;

public class PrimogemcraftModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(Registries.ENCHANTMENT, PrimogemcraftMod.MODID);
	public static final DeferredHolder<Enchantment, Enchantment> CESHIFUMO_01 = REGISTRY.register("ceshifumo_01", () -> new Ceshifumo01Enchantment());
	public static final DeferredHolder<Enchantment, Enchantment> FUMOYUZHEZN = REGISTRY.register("fumoyuzhezn", () -> new FumoyuzheznEnchantment());
	public static final DeferredHolder<Enchantment, Enchantment> FMYUZHOUSUIPIAN = REGISTRY.register("fmyuzhousuipian", () -> new FmyuzhousuipianEnchantment());
}
