package net.mcreator.ceshi.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class GUIsxp100Procedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		entity.getPersistentData().putDouble("GUI_yzsp_sl", (entity.getPersistentData().getDouble("GUI_yzsp_sl") + 100));
		if (guistate.get("text:cunzhe_shuliang") instanceof EditBox _tf)
			_tf.setValue((new java.text.DecimalFormat("##.##").format(entity.getPersistentData().getDouble("GUI_yzsp_sl"))));
	}
}
