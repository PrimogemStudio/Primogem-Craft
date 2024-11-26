package net.mcreator.ceshi.procedures;

import net.neoforged.fml.ModList;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class PyjlsxProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		a = 0.12 + 0.03 * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		XsfHSProcedure.execute(itemstack, false, false, (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) * (ModList.get().isLoaded("genshincraft") ? a * 0.025 : a));
	}
}
