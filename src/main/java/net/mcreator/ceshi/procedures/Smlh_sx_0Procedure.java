package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class Smlh_sx_0Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			itemstack.getOrCreateTag().putDouble("lihe_jishi", (itemstack.getOrCreateTag().getDouble("lihe_jishi") + 1));
			if (itemstack.getOrCreateTag().getDouble("lihe_jishi") >= 20) {
				itemstack.getOrCreateTag().putDouble("lihe_jishi", 0);
				itemstack.getOrCreateTag().putDouble("lihe_jishi_0", (itemstack.getOrCreateTag().getDouble("lihe_jishi_0") + 1));
				if (itemstack.getOrCreateTag().getDouble("lihe_jishi_0") == 61) {
					if (Math.random() < 0.5) {
						for (int index0 = 0; index0 < Mth.nextInt(RandomSource.create(), 1, 3); index0++) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
										new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("pgc:lihe_0"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
								entityToSpawn.setPickUpDelay(5);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (entity.getX()), (entity.getY()), (entity.getZ()),
									new ItemStack((ForgeRegistries.ITEMS.tags().getTag(ItemTags.create(new ResourceLocation("pgc:lihe_1"))).getRandomElement(RandomSource.create()).orElseGet(() -> Items.AIR))));
							entityToSpawn.setPickUpDelay(5);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					itemstack.shrink(1);
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.glow_item_frame.break")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5);
						} else {
							_level.playLocalSound(x, y, z, ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.glow_item_frame.break")), SoundSource.PLAYERS, (float) 0.5, (float) 1.5, false);
						}
					}
				}
			}
		}
	}
}
