package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class LmsjmsProcedure {
	public static String execute(ItemStack itemstack) {
		double a = 0;
		a = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
		return MSHSwuqi00Procedure.execute(itemstack,
				"\u00A76\u00A7l\u00A7n\u88AB\u52A8" + "\n" + "\u00A7e\u751F\u547D\u503C\u9AD8\u4E8E90%\u65F6\u653B\u51FB\u529B\u63D0\u5347\u00A7b" + new java.text.DecimalFormat("##.##%").format(0.14 + 0.035 * a));
	}
}
