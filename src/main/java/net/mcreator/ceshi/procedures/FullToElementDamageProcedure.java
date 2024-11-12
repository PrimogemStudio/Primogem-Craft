package net.mcreator.ceshi.procedures;

import net.hackermdch.pgc.GenshinCraftAPI;
import net.minecraft.world.damagesource.DamageSource;

import static net.hackermdch.pgc.CustomAPI.GenshinCraftLoaded;

public class FullToElementDamageProcedure {
    public static DamageSource execute(DamageSource damagesource, boolean apply, boolean cooldown, boolean critical, boolean knockback, double count, double type) {
        return GenshinCraftLoaded ? GenshinCraftAPI.toElement(damagesource, (int) type, (int) count, apply, critical, cooldown, knockback) : damagesource;
    }
}
