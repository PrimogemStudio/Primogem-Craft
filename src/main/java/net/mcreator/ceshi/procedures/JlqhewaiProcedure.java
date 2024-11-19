package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import net.hackermdch.pgc.CustomAPI;

public class JlqhewaiProcedure {
	public static void execute(ItemStack itemstack) {
		double a = 0;
		ItemStack stack = ItemStack.EMPTY;
		String s1 = "";
		{
			final String _tagName = "jing_lian_shua_xin";
			final boolean _tagValue = true;
			CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
		}
		if (itemstack.getItem() == PrimogemcraftModItems.JSLYZH.get()) {
			stack = itemstack;
			a = 0.24 + 0.06 * itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			var attr = CustomAPI.getAttributes(stack);
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
	}
}
