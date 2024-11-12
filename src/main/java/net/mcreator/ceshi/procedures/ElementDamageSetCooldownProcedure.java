package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.world.damagesource.DamageSource;

import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;

public class ElementDamageSetCooldownProcedure {
    public static DamageSource execute(DamageSource damagesource, boolean value) {
        return GenshinCraftLoaded ? GenshinCraftAPI.setCooldown(damagesource, value) : damagesource;
    }
}
