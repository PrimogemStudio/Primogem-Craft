package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

public class WuqidengjiHSProcedure {
	public static boolean execute(LevelAccessor world, Entity entity, ItemStack item, double zhi) {
		if (entity == null)
			return false;
		double a1 = 0;
		double a11 = 0;
		double a = 0;
		double a2 = 0;
		double b = 0;
		double a12 = 0;
		double c = 0;
		double z = 0;
		ItemStack i1 = ItemStack.EMPTY;
		if (item.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			i1 = item;
			{
				final String _tagName = "deng_ji";
				final double _tagValue = (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") + zhi);
				CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
			}
			z = (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN));
			if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") > z) {
				{
					final String _tagName = "deng_ji";
					final double _tagValue = z;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7d\u63D0\u4F9B\u7684\u6B66\u5668\u5DF2\u8FBE\u81F3\u8BBE\u5B9A\u7684\u6700\u9AD8\u7B49\u7EA7\uFF01"), false);
			}
			WuqishuaxinProcedure.execute(world, entity, i1);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7c\u63D0\u4F9B\u7684\u7269\u54C1\u975E\u7948\u613F\u6B66\u5668\uFF01"), false);
			return false;
		}
		return false;
	}
}
