package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Axtsx4Procedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.is(ItemTags.create(new ResourceLocation("primogemcraft:yuansutaotie")))) {
			itemstack.getOrCreateTag().putDouble("aixu_tao_zhi", ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQBING.get())) : false) ? 1 : 0.5));
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("primogemcraft:yuansutaozuanshi")))) {
			itemstack.getOrCreateTag().putDouble("aixu_tao_zhi", ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQBING.get())) : false) ? 1.5 : 1));
		}
		if (itemstack.is(ItemTags.create(new ResourceLocation("primogemcraft:yuansutaoxiajiehejin")))) {
			itemstack.getOrCreateTag().putDouble("aixu_tao_zhi", ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQBING.get())) : false) ? 2.5 : 2));
		}
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi") >= 2) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem
					|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof AxeItem) {
				if (entity instanceof LivingEntity _entity)
					_entity.removeEffect(MobEffects.MOVEMENT_SLOWDOWN);
				if (!(entity instanceof LivingEntity _livEnt28 && _livEnt28.hasEffect(MobEffects.JUMP))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100,
								(int) (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
										+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
										+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
										+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")) * 0.5),
								true, false));
				}
			}
		}
		AxbykjsxxfProcedure.execute(entity);
	}
}
