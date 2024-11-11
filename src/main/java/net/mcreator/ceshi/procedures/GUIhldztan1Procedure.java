package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModGameRules;

import java.util.function.Supplier;
import java.util.Map;

public class GUIhldztan1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		boolean lg0 = false;
		double a = 0;
		double b = 0;
		double c = 0;
		if (!world.isClientSide()) {
			i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(5)).getItem() : ItemStack.EMPTY);
			if (Math.random() < i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("qianghua_touzi_gailv")) {
				b = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("touzi_fenwei_0");
				c = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("touzi_fenwei_1");
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal(("\u00A7a\u00A7l\u89E6\u53D1\u9AB0\u5B50\u6548\u679C\uFF0C\u5C06\u968F\u673A\u51CF\u5C11\u00A79" + new java.text.DecimalFormat("%").format(b * 100) + "~"
							+ new java.text.DecimalFormat("%").format(c * 100) + "\u00A7a\u77FF\u77F3\u6D88\u8017\uFF01")), false);
			}
		}
		i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		if (!(i1.getItem() == Blocks.AIR.asItem()) && i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji") == 0) {
				{
					final String _tagName = "deng_ji";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a >= 60) {
				GUIhldztan1SHProcedure.execute(world, x, y, z, entity, i1, (world.getLevelData().getGameRules().getInt(PrimogemcraftModGameRules.GUIZEWUQISHANGXIAN)), b, c, 8);
			}
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a >= 30 && a < 60) {
				GUIhldztan1SHProcedure.execute(world, x, y, z, entity, i1, 60, b, c, 7);
			}
			a = i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("deng_ji");
			if (a < 30) {
				GUIhldztan1SHProcedure.execute(world, x, y, z, entity, i1, 30, b, c, 6);
			}
		}
	}
}
