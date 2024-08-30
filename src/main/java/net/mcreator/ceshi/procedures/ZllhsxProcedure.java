package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZllhsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("entity.pig.saddle")), SoundSource.PLAYERS, (float) 0.3, Mth.nextInt(RandomSource.create(), (int) 0.9, (int) 1.1), false);
			}
		}
		if (entity.isShiftKeyDown()) {
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLH.get()) {
				a = itemstack.getCount();
				itemstack.shrink((int) a);
				for (int index0 = 0; index0 < (int) a; index0++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_01");
				}
				a = 0;
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_2.get()) {
				a = itemstack.getCount();
				itemstack.shrink((int) a);
				for (int index1 = 0; index1 < (int) a; index1++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_02");
				}
				a = 0;
			}
			if (itemstack.getItem() == PrimogemcraftModItems.Q_QU_HANG_ZHOULLH.get()) {
				a = itemstack.getCount();
				itemstack.shrink((int) a);
				for (int index2 = 0; index2 < (int) a; index2++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_03");
				}
				a = 0;
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_4.get()) {
				a = itemstack.getCount();
				itemstack.shrink((int) a);
				for (int index3 = 0; index3 < (int) a; index3++) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"loot spawn ~ ~1 ~ loot primogemcraft:entities/zllh_4zlp");
				}
				a = 0;
			}
		} else {
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLH.get()) {
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_01");
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_2.get()) {
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_02");
			}
			if (itemstack.getItem() == PrimogemcraftModItems.Q_QU_HANG_ZHOULLH.get()) {
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~ ~ loot primogemcraft:blocks/zllh_03");
			}
			if (itemstack.getItem() == PrimogemcraftModItems.QHZLLH_4.get()) {
				itemstack.shrink(1);
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~1 ~ loot primogemcraft:entities/zllh_4zlp");
			}
		}
	}
}
