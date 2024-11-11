package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import net.hackermdch.pgc.CustomAPI;

import java.util.function.Supplier;
import java.util.Map;

public class GUIhldztan1SHProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, double deng_ji, double fanwei_0, double fanwei_1, double wei_zhi) {
		if (entity == null)
			return false;
		ItemStack i1 = ItemStack.EMPTY;
		ItemStack stack = ItemStack.EMPTY;
		double a = 0;
		double b = 0;
		double c = 0;
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
				((Slot) _slots.get((int) wei_zhi)).remove((int) (a - a * Mth.nextInt(RandomSource.create(), (int) fanwei_0, (int) fanwei_1)));
				_player.containerMenu.broadcastChanges();
			}
			a = item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			b = GUIhldztwqqhszhsProcedure.execute(world, 0.05, a, (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN)));
			c = c + b;
			b = GUIhldztwqqhszhsProcedure.execute(world, 0.02, a, 60);
			c = c + b;
			b = GUIhldztwqqhszhsProcedure.execute(world, 0.01, a, 30);
			c = c + b;
			stack = item;
			var attr = CustomAPI.getAttributes(stack);
			attr.add(Attributes.ATTACK_DAMAGE, "djjc", c, AttributeModifier.Operation.ADD_VALUE, EquipmentSlotGroup.MAINHAND);
			attr.apply();
			if (!world.isClientSide()) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, (float) 0.3, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, (float) 0.3, 1, false);
					}
				}
			}
			return true;
		}
		return false;
	}
}
