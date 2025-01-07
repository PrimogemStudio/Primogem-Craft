package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.component.DataComponents;

public class DiaoyongwuqijinglianHSProcedure {
	public static void execute(ItemStack item, double zhi) {
		ItemStack a = ItemStack.EMPTY;
		a = item;
		{
			final String _tagName = "jing_lian";
			final double _tagValue = (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + zhi);
			CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (a.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") >= 4) {
			{
				final String _tagName = "jing_lian";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, a, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
