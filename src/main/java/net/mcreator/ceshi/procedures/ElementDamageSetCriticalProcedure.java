package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.world.damagesource.DamageSource;

import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;

public class ElementDamageSetCriticalProcedure {
    public static DamageSource execute(DamageSource damagesource, boolean value) {
        return GenshinCraftLoaded ? GenshinCraftAPI.setCritical(damagesource, value) : damagesource;
    }
}
