package net.mcreator.ceshi.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

public class Axtsx2Procedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double a = 0;
		if (!world.isClientSide()) {
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
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem
						|| (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() instanceof PickaxeItem) {
					entity.getPersistentData().putDouble("yuanbenshengminzhi2", (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1));
					if (!(entity instanceof LivingEntity _livEnt30 && _livEnt30.hasEffect(MobEffects.ABSORPTION))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 1200,
									(int) (((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
											+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
											+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
											+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")) * 0.5 - 2),
									true, false));
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format(((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) * Math.round(a) * 0.1))), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(
								Component.literal((new java.text.DecimalFormat("##.##").format(entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0))),
								false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal((new java.text.DecimalFormat("##.##").format((entity.getPersistentData().getDouble("yuanbenshengminzhi2") / 4) * Math.floor(a) * 0.1))), false);
					a = a + (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
							+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
							+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi")
							+ (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).getOrCreateTag().getDouble("aixu_tao_zhi");
					if (!(entity instanceof LivingEntity _livEnt54 && _livEnt54.hasEffect(MobEffects.HEALTH_BOOST)) && !(entity instanceof LivingEntity _livEnt55 && _livEnt55.hasEffect(PrimogemcraftModMobEffects.SZTSXCWDP.get()))) {
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(MobEffects.HEALTH_BOOST, 200000, (int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) / 4) * Math.round(a) * 0.1), false, false));
					} else {
						if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getAmplifier() : 0) != Math
								.floor((entity.getPersistentData().getDouble("yuanbenshengminzhi2") / 4) * Math.floor(a) * 0.1)) {
							entity.getPersistentData().putBoolean("yuanbenshengminzhi2", false);
							if (entity instanceof LivingEntity _entity)
								_entity.removeEffect(MobEffects.HEALTH_BOOST);
							if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
								_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP.get(), 20, 0, false, false));
						}
					}
				} else {
					if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getDuration() : 0) >= 8000) {
						entity.getPersistentData().putBoolean("yuanbenshengminzhi2", false);
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(MobEffects.HEALTH_BOOST);
						if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
							_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP.get(), 20, 0, false, false));
					}
				}
			} else {
				if ((entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(MobEffects.HEALTH_BOOST) ? _livEnt.getEffect(MobEffects.HEALTH_BOOST).getDuration() : 0) >= 8000) {
					entity.getPersistentData().putBoolean("yuanbenshengminzhi2", false);
					if (entity instanceof LivingEntity _entity)
						_entity.removeEffect(MobEffects.HEALTH_BOOST);
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.SZTSXCWDP.get(), 20, 0, false, false));
				}
			}
		}
	}
}
