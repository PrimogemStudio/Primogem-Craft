package net.mcreator.ceshi.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class ZizaitaoshuxingProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		double b = 0;
		a = (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(PrimogemcraftModItems.HQFENG.get())) : false) ? 0.5 : 0;
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaotie")))) {
			{
				final String _tagName = "zizai_tao_zhi";
				final double _tagValue = (0.5 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaozuanshi")))) {
			{
				final String _tagName = "zizai_tao_zhi";
				final double _tagValue = (1 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("primogemcraft:yuansutaoxiajiehejin")))) {
			{
				final String _tagName = "zizai_tao_zhi";
				final double _tagValue = (2 + a);
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		b = (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi")
				+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("zizai_tao_zhi");
		if (!(entity instanceof LivingEntity _livEnt21 && _livEnt21.hasEffect(MobEffects.SLOW_FALLING)) && !entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
			if (b >= 2) {
				if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 100, (int) (b * 0.5 - 1), true, false));
			}
		}
		if (!(entity instanceof LivingEntity _livEnt24 && _livEnt24.hasEffect(MobEffects.JUMP))) {
			if (b >= 4) {
				if (!entity.getPersistentData().getBoolean("zzss_kj_hjxz")) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b + 2), true, false));
				} else {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, 100, (int) (b - 1), true, false));
				}
			}
		}
	}
}
