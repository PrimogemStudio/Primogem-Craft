package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.world.damagesource.DamageSource;

import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;

public class ToElementDamageProcedure {
    public static DamageSource execute(DamageSource damagesource, double count, double type) {
        return GenshinCraftLoaded ? GenshinCraftAPI.toElement(damagesource, (int) type, (float) count) : damagesource;
    }
}
