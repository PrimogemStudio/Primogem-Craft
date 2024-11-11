package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class MsSHwuqiProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + 1;
		var sb = new StringBuilder();
		for (int index0 = 0; index0 < (int) a; index0++) {
			sb.append('■');
		}
		for (int index1 = 0; index1 < (int) (5 - a); index1++) {
			sb.append('□');
		}
		return new java.text.DecimalFormat("Lv:").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji")) + "\u00A7b\u7CBE\u70BC\u8FDB\u5EA6:" + sb.toString();
	}
}
