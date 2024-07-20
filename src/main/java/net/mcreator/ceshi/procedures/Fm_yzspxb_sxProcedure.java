package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.mcreator.ceshi.init.PrimogemcraftModEnchantments;

public class Fm_yzspxb_sxProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ItemStack a = ItemStack.EMPTY;
		ItemStack b = ItemStack.EMPTY;
		ItemStack a0 = ItemStack.EMPTY;
		ItemStack a1 = ItemStack.EMPTY;
		ItemStack a2 = ItemStack.EMPTY;
		ItemStack a3 = ItemStack.EMPTY;
		if (!world.isClientSide()) {
			a = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() >= a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			b = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), b) != 0 && !b.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (b.getDamageValue() >= b.getMaxDamage() * 0.01 * b.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					b.setDamageValue((int) (b.getDamageValue() - b.getMaxDamage() * 0.01 * b.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a0 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a0) != 0 && !a0.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a0.getDamageValue() >= a0.getMaxDamage() * 0.01 * a0.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a0.setDamageValue((int) (a0.getDamageValue() - a0.getMaxDamage() * 0.01 * a0.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a1 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a1) != 0 && !a1.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a0.getDamageValue() >= a0.getMaxDamage() * 0.01 * a0.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a0.setDamageValue((int) (a0.getDamageValue() - a0.getMaxDamage() * 0.01 * a0.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a2 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a2) != 0 && !a2.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a2.getDamageValue() >= a2.getMaxDamage() * 0.01 * a2.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a2.setDamageValue((int) (a2.getDamageValue() - a2.getMaxDamage() * 0.01 * a2.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a3 = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a3) != 0 && !a3.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a3.getDamageValue() >= a3.getMaxDamage() * 0.01 * a3.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a3.setDamageValue((int) (a3.getDamageValue() - a3.getMaxDamage() * 0.01 * a3.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
		}
	}
}
