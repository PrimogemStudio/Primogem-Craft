package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;

public class MSHSwuqi00Procedure {
	public static String execute(ItemStack itemstack, String miaoshu) {
		if (miaoshu == null)
			return "";
		return MsSHwuqiProcedure.execute(itemstack) + "" + Diaoyongshift0Procedure.execute(miaoshu, "\u63CF\u8FF0")
				+ HSctrlProcedure.execute("\u00A7c\u00A7l\u00A7n\u4F7F\u7528 \u534E\u4E3D\u953B\u9020\u53F0 \u5F3A\u5316\u6B66\u5668" + "\n" + "\u00A7b\u4F7F\u7528 \u53E0\u5F71\u5668 \u00A76\u7CBE\u70BC\u00A7b\u6B66\u5668" + "\n"
						+ "\u00A7f\u7CBE\u953B\u7528\u6742\u77FF\u00A76\uFF1ALv\u00A7e1\u00A76-Lv\u00A7e30" + "\n" + "\u00A7b\u7CBE\u953B\u7528\u826F\u77FF\u00A76\uFF1ALv\u00A7e30\u00A76-Lv\u00A7e60" + "\n"
						+ "\u00A7d\u7CBE\u953B\u7528\u9B54\u77FF\u00A76\uFF1ALv\u00A7e60\u00A7d \u2191\u2191", "\u6559\u7A0B");
	}
}
