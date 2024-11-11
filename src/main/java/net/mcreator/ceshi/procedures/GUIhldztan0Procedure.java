package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

public class GUIhldztan0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack i1 = ItemStack.EMPTY;
		double b = 0;
		boolean lg0 = false;
		i1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(0)).getItem() : ItemStack.EMPTY);
		if (!(i1.getItem() == Blocks.AIR.asItem()) && i1.is(ItemTags.create(ResourceLocation.parse("pgc:wuqi")))) {
			if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") == 0) {
				{
					final String _tagName = "jing_lian";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			for (int index0 = 0; index0 < 4; index0++) {
				b = b + 1;
				if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) b)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
					if (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") < 5) {
						{
							final String _tagName = "jing_lian";
							final double _tagValue = (i1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jing_lian") + 1);
							CustomData.update(DataComponents.CUSTOM_DATA, i1, tag -> tag.putDouble(_tagName, _tagValue));
						}
						if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
							((Slot) _slots.get((int) b)).set(ItemStack.EMPTY);
							_player.containerMenu.broadcastChanges();
						}
						lg0 = true;
					}
				}
			}
			if (!world.isClientSide()) {
				if (lg0) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, 1, 1);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("primogemcraft:jingyanshu00")), SoundSource.BLOCKS, 1, 1, false);
						}
					}
				}
			}
		}
	}
}
