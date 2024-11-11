package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;

import net.hackermdch.pgc.CustomAPI;

public class ExampleTestProcedure {
	public static void execute(ItemStack itemstack) {
		ItemStack stack = ItemStack.EMPTY;
		stack = itemstack;
		var attr = CustomAPI.getAttributes(stack);
		attr.add(Attributes.ATTACK_DAMAGE, "aa", 1, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.HAND);
		attr.apply();
	}
}
