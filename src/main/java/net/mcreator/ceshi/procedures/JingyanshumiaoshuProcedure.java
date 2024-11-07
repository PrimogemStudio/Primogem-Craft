package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class JingyanshumiaoshuProcedure {
	public static String execute(ItemStack itemstack) {
		return Diaoyongshift0Procedure.execute(ExampleTooltipProcedure.execute(itemstack, "\u00A77\u5B58\u50A8\u7684\u7ECF\u9A8C\u503C") + "\n"
				+ HSctrlProcedure.execute("\u00A7c\u00A7l\u5347\u7EA7\u524D\u8BB0\u5F97\u53D6\u51FA\u7ECF\u9A8C\uFF01", "\u00A7c\u26A0\u91CD\u8981\u4FE1\u606F"), "\u8BE6\u60C5");
	}
}
