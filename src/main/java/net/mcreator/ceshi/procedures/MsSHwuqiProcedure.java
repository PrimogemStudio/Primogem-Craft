package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;

public class MsSHwuqiProcedure {
	public static String execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return "";
		double a = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + 1;
		var sb = new StringBuilder();
		for (int index0 = 0; index0 < (int) a; index0++) {
			sb.append('■');
		}
		for (int index1 = 0; index1 < (int) (5 - a); index1++) {
			sb.append('□');
		}
		return new java.text.DecimalFormat("Lv:").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1) + "\n" + "\u00A76\u7CBE\u70BC:"
				+ (sb.toString() + "" + (entity instanceof LivingEntity _livEnt4 && _livEnt4.hasEffect(PrimogemcraftModMobEffects.SKLJXG) ? "\u00A7b\u25A0" : "")) + "\n";
	}
}
