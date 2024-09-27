package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.PrimogemcraftMod;

public class DbmlksxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass")))
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass/colorless")))) {
			PrimogemcraftMod.queueServerWork(60, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.1, 0.5));
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.1, 0.5), false);
					}
				}
				if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass")))
						|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass/colorless")))) {
					PrimogemcraftMod.queueServerWork(60, () -> {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.1, 0.5));
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.1, 0.5), false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.5, 0.8));
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.5, 0.8), false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass")))
								|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass/colorless")))) {
							PrimogemcraftMod.queueServerWork(60, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.5, 0.8));
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 0.5, 0.8), false);
									}
								}
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 1, 1.5));
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.glass.hit")), SoundSource.NEUTRAL, 1, (float) Mth.nextDouble(RandomSource.create(), 1, 1.5), false);
									}
								}
								if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass")))
										|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("c:glass/colorless")))) {
									PrimogemcraftMod.queueServerWork(60, () -> {
										world.levelEvent(2001, BlockPos.containing(x, y - 1, z), Block.getId((world.getBlockState(BlockPos.containing(x, y - 1, z)))));
										world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
									});
								}
							});
						}
					});
				}
			});
		}
	}
}
