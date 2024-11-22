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
		stack = itemstack;
		var attr = CustomAPI.getAttributes(stack);
		if (stack.getItem() == PrimogemcraftModItems.JSLYZH.get()) {
			a = 0.24 + 0.06 * stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.TKZR.get()) {
			a = 0.08 + 0.02 * stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
		if (stack.getItem() == PrimogemcraftModItems.PYJL.get()) {
			a = 0.2 + 0.05 * stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			attr.add(Attributes.MAX_HEALTH, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_BASE, EquipmentSlotGroup.MAINHAND);
			a = 0.1 + 0.025 * stack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian");
			attr.add(Attributes.ATTACK_DAMAGE, "bd", a, AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL, EquipmentSlotGroup.MAINHAND);
			attr.apply();
		}
	}
}
