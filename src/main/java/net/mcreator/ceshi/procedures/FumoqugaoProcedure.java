package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.ItemStack;

import javax.annotation.Nullable;

import java.util.Optional;

import com.google.common.collect.Maps;

@Mod.EventBusSubscriber
public class FumoqugaoProcedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getItem().getItem());
	}

	public static void execute(ItemStack itemstack) {
		execute(null, itemstack);
	}

	private static void execute(@Nullable Event event, ItemStack itemstack) {
		ItemStack i1 = ItemStack.EMPTY;
		if (itemstack.isEnchanted()) {
			i1 = itemstack;
			{
				var stack = i1;
				var enchs = stack.getEnchantmentTags();
				var map = Maps.<Enchantment, Integer>newLinkedHashMap();
				for (int i = 0; i < enchs.size(); i++) {
					var e = enchs.getCompound(i);
					Optional.ofNullable(ForgeRegistries.ENCHANTMENTS.getValue(EnchantmentHelper.getEnchantmentId(e))).ifPresent(en -> {
						var lvl = EnchantmentHelper.getEnchantmentLevel(e);
						map.computeIfPresent(en, (a, b) -> Math.max(lvl, b));
						map.putIfAbsent(en, lvl);
					});
				}
				enchs.clear();
				EnchantmentHelper.setEnchantments(map, stack);
			}
		}
	}
}
