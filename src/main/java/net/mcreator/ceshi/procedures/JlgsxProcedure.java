package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModBlocks;

public class JlgsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity.isShiftKeyDown()) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:stone"))) || (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:stone_bricks")))
					|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:cobblestone")))) {
				{
					ItemStack _ist = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
					_ist.hurtAndBreak((int) Mth.nextDouble(RandomSource.create(), 1, 5), RandomSource.create(), null, () -> {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					});
				}
				if (entity instanceof Player _player)
					_player.getCooldowns().addCooldown(itemstack.getItem(), (int) ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQYAN.get())) : false) ? 200 : 400));
				if (Math.random() < 0.6) {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.trident.thunder")), SoundSource.BLOCKS, (float) 0.5, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("item.trident.thunder")), SoundSource.BLOCKS, (float) 0.5, 2, false);
						}
					}
					if (Math.random() < 0.03) {
						world.setBlock(BlockPos.containing(x, y, z), PrimogemcraftModBlocks.LIANJIAXIAJIEHEJINKUAI.get().defaultBlockState(), 3);
					} else {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.POLISHED_DEEPSLATE
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:ore_bearing_ground/deepslate")))
								|| (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("c:cobblestone/deepslate")))) {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 3);
						} else {
							world.setBlock(BlockPos.containing(x, y, z), Blocks.GOLD_ORE.defaultBlockState(), 3);
						}
					}
				} else {
					if (world instanceof Level _level) {
						if (!_level.isClientSide()) {
							_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, (float) 0.5, 2);
						} else {
							_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("block.beacon.deactivate")), SoundSource.BLOCKS, (float) 0.5, 2, false);
						}
					}
				}
			}
		}
	}
}
