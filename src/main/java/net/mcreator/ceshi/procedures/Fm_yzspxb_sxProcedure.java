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
		if (!world.isClientSide()) {
			a = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
			if (EnchantmentHelper.getItemEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get(), a) != 0 && !a.is(ItemTags.create(new ResourceLocation("pgc:token_mending")))) {
				if (a.getDamageValue() > a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PrimogemcraftModItems.YUZHOUSUIPIAN.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					a.setDamageValue((int) (a.getDamageValue() - a.getMaxDamage() * 0.01 * a.getEnchantmentLevel(PrimogemcraftModEnchantments.FMYUZHOUSUIPIAN.get()) * 2));
				}
			}
			a = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
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
