package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.FireworkExplosion;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.client.Minecraft;

import java.util.List;

public class BhmglzProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double x = 0;
		double y = 0;
		double z = 0;
		if (entity.getPersistentData().getBoolean("lizi")) {
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
			new Object() {
				void run(double x, double y, double z) {
					var colors = it.unimi.dsi.fastutil.ints.IntList.of(0xFF9FE0, 0xAEEDFF);
					var fadeColors = it.unimi.dsi.fastutil.ints.IntList.of(0xF4C6FF);
					var pt = new FireworkParticles.Starter(Minecraft.getInstance().level, x, y, z, 0, 0, 0, Minecraft.getInstance().particleEngine, List.of(FireworkExplosion.DEFAULT));
					pt.createParticleBall(0.5, 3, colors, fadeColors, true, false);
				}
			}.run(x, y, z);
			entity.getPersistentData().putBoolean("lizi", false);
		}
	}
}
