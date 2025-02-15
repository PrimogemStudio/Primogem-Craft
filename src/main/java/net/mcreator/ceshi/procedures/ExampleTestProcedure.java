package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.client.Minecraft;

import java.util.List;

public class ExampleTestProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack stack = ItemStack.EMPTY;
		double x = 0;
		double y = 0;
		double z = 0;
		if (world.isClientSide()) {
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
			new Object() {
				void run(double x, double y, double z) {
					var colors = it.unimi.dsi.fastutil.ints.IntList.of(0xff00ff);
					var fadeColors = it.unimi.dsi.fastutil.ints.IntList.of();
					var pt = new FireworkParticles.Starter(Minecraft.getInstance().level, x, y, z, 0, 0, 0, Minecraft.getInstance().particleEngine, List.of(FireworkExplosion.DEFAULT));
					pt.createParticleBall(0.5, 3, colors, fadeColors, true, false);
				}
			}.run(x, y, z);
		}
	}
}
