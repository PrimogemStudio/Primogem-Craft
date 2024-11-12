package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class TcllkmsProcedure {
	public static String execute(ItemStack itemstack) {
		return "\u00A77\u56DE\u6536\u5F3A\u5316\u6B66\u5668\u4E3A\u5F3A\u5316\u6750\u6599" + "\n" + "\u00A76\u8FD4\u8FD8\u53E0\u5F71\u5668\u00A7b:"
				+ new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian")) + "\n" + "\u00A76\u8FD4\u8FD8\u00A7b"
				+ new java.text.DecimalFormat("").format(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji")) + "\u00A76\u7EA7\u5F3A\u5316\u6750\u6599" + "\n"
				+ "\u00A7c\u00A7l\u8FDE\u7EED\u4F7F\u7528\u65E7\u6570\u636E\u5C06\u88AB\u8986\u76D6\uFF01";
	}
}
