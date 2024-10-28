package net.mcreator.ceshi.procedures;

import net.minecraft.client.gui.screens.Screen;

public class HSaltProcedure {
	public static String execute(String alt, String alt0) {
		if (alt == null || alt0 == null)
			return "";
		if (Screen.hasAltDown()) {
			return alt;
		}
		return "\u00A77\u6309\u4F4F[Alt]\u67E5\u770B" + alt0;
	}
}
