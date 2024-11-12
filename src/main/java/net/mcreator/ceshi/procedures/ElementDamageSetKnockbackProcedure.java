package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.world.damagesource.DamageSource;

import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;

public class ElementDamageSetKnockbackProcedure {
    public static DamageSource execute(DamageSource damagesource, boolean value) {
        return GenshinCraftLoaded ? GenshinCraftAPI.setKnockback(damagesource, value) : damagesource;
    }
}
