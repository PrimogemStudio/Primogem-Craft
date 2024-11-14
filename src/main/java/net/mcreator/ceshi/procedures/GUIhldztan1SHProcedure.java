package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.network.PrimogemcraftModVariables;
import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import net.hackermdch.pgc.CustomAPI;

import java.util.function.Supplier;
import java.util.Map;

public class GUIhldztan1SHProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item, double deng_ji, double fanwei_0, double fanwei_1, double wei_zhi) {
		if (entity == null)
			return false;
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		double b = 0;
		double c = 0;
		double a1 = 0;
		double a2 = 0;
		double a11 = 0;
		double a12 = 0;
		if (!world.isClientSide()) {
			a = new Object() {
				public int getAmount(int sltid) {
					if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
						ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
						if (stack != null)
							return stack.getCount();
					}
					return 0;
				}
			}.getAmount((int) wei_zhi);
			b = deng_ji - item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			a = a > b ? b : a;
			{
				final String _tagName = "deng_ji";
				final double _tagValue = (item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + a);
				CustomData.update(DataComponents.CUSTOM_DATA, item, tag -> tag.putDouble(_tagName, _tagValue));
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
				((Slot) _slots.get((int) wei_zhi)).remove((int) (a - a * Mth.nextDouble(RandomSource.create(), fanwei_0, fanwei_1)));
				_player.containerMenu.broadcastChanges();
			}
			a = item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + 1;
			stack = item;
			var attr = CustomAPI.getAttributes(stack);
			a1 = 30;
			a2 = 60;
			a11 = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGHAI));
			a12 = entity.getData(PrimogemcraftModVariables.PLAYER_VARIABLES).jun_heng * 0.01;
			if (a > a2) {
				b = a1 * a11 * (0.01 + a12);
				c = c + b;
				b = a1 * a11 * (0.02 + a12 * 1.5);
				c = c + b;
				c = c + (a - a2) * a11 * (0.03 + a12 * 2);
				attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
				attr.apply();
				return true;
			} else if (a >= a1 && a <= a2) {
				b = a1 * a11 * (0.01 + a12);
				c = c + b;
				c = c + (a - a1) * a11 * (0.02 + a12 * 1.5);
				attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
				attr.apply();
				return true;
			} else if (a < a1) {
				c = c + a * a11 * (0.01 + a12);
				attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
				attr.apply();
				return true;
			}
		}
		return false;
	}
}
