package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEnchantments;

public class FMhsxiubuProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack item) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			a = item;
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
		}
	}
}
