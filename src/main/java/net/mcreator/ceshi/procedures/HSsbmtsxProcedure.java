package net.mcreator.ceshi.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.HashSet;

public class HSsbmtsxProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack item, double lengque) {
		if (entity == null)
			return;
		Entity e = null;
		double out = 0;
		if (!world.isClientSide()) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal((item.getDisplayName().getString() + "\u00A7c\u5DF2\u635F\u574F\uFF01")), false);
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(new ResourceLocation("primogemcraft:qiwusunhuai066")), SoundSource.PLAYERS, 1, 1, false);
				}
			}
			if (entity instanceof Player _player)
				_player.getCooldowns().addCooldown(item.getItem(), (int) lengque);
			e = entity;
			{
				var set = new HashSet<Item>();
				if (e instanceof Player player) {
					player.getInventory().items.forEach(itemstack -> {
						if (itemstack.getItem() == item.getItem())
							return;
						if (set.contains(itemstack.getItem()))
							return;
						if (Sbmtsxhs0Procedure.execute(itemstack)) {
							set.add(itemstack.getItem());
							itemstack.shrink(1);
						}
					});
				}
				out = set.size();
			}
			for (int index0 = 0; index0 < (int) out; index0++) {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"loot spawn ~ ~ ~ loot primogemcraft:entities/qqiwuzhanlipinshiti");
			}
		}
	}
}
