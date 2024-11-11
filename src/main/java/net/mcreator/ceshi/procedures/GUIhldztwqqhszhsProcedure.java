package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class GUIhldztwqqhszhsProcedure {
	public static double execute(LevelAccessor world, double beilv, double deng_ji, double zuida_dengji) {
		double a = 0;
		a = deng_ji - zuida_dengji;
		return (deng_ji >= zuida_dengji ? zuida_dengji : deng_ji) * (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGHAI)) * beilv;
	}
}
