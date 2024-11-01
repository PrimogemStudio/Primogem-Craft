package net.mcreator.ceshi.procedures;

import net.minecraft.client.gui.screens.Screen;

public class Diaoyongshift0Procedure {
	public static String execute(String shift, String shift0) {
		if (shift == null || shift0 == null)
			return "";
		if (Screen.hasShiftDown()) {
			return shift + "\n";
		}
		return "\u00A77\u6309\u4F4F[Shift]\u67E5\u770B" + shift0 + "\n";
	}
}
