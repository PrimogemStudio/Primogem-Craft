package net.mcreator.ceshi.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;

import net.mcreator.ceshi.init.PrimogemcraftModMobEffects;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class FenlieggzsxProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		Entity e1 = null;
		String s1 = "";
		ItemStack a = ItemStack.EMPTY;
		ItemStack b = ItemStack.EMPTY;
		ItemStack c0 = ItemStack.EMPTY;
		ItemStack c1 = ItemStack.EMPTY;
		ItemStack c2 = ItemStack.EMPTY;
		ItemStack c3 = ItemStack.EMPTY;
		if (sourceentity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_0.get()) && sourceentity instanceof Player && entity instanceof LivingEntity _livEnt2 && _livEnt2.getMobType() == MobType.UNDEAD
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1) <= (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1)
				&& Math.random() <= ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()).getAmplifier() : 0) + 2) * 0.05) {
			if (!world.isClientSide()) {
				s1 = ForgeRegistries.ENTITY_TYPES.getKey(entity.getType()).toString();
				var t = entity.getType();
				var p = entity.blockPosition();
				var sw = (ServerLevel) world;
				e1 = t.spawn(sw, p, MobSpawnType.MOB_SUMMONED);
				if (e1 instanceof LivingEntity _entity && !_entity.level().isClientSide())
					_entity.addEffect(new MobEffectInstance(PrimogemcraftModMobEffects.HSLGGZFUZHIPIN.get(), 60, 0));
				{
					Entity _entity = e1;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(PrimogemcraftModItems.TESHUKUIJIA_01_HELMET.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PrimogemcraftModItems.TESHUKUIJIA_01_HELMET.get()));
					}
				}
				if (e1 instanceof LivingEntity _entity) {
					ItemStack _setstack = new ItemStack(PrimogemcraftModItems.QWGGZFENLIE_B.get()).copy();
					_setstack.setCount(1);
					_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
				if (sourceentity instanceof LivingEntity _livEnt11 && _livEnt11.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get())) {
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()).getAmplifier() : 0) == 0) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.IRON_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.IRON_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.IRON_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.IRON_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.IRON_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.IRON_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.GOLDEN_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()).getAmplifier() : 0) == 1) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.DIAMOND_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.DIAMOND_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.DIAMOND_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.DIAMOND_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.IRON_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
					if ((sourceentity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()) ? _livEnt.getEffect(PrimogemcraftModMobEffects.FZGGZXG_1.get()).getAmplifier() : 0) == 2) {
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(2, new ItemStack(Items.NETHERITE_CHESTPLATE));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(Items.NETHERITE_CHESTPLATE));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(1, new ItemStack(Items.NETHERITE_LEGGINGS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(Items.NETHERITE_LEGGINGS));
							}
						}
						{
							Entity _entity = e1;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(0, new ItemStack(Items.NETHERITE_BOOTS));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(Items.NETHERITE_BOOTS));
							}
						}
						if (e1 instanceof LivingEntity _entity) {
							ItemStack _setstack = new ItemStack(Items.DIAMOND_SWORD).copy();
							_setstack.setCount(1);
							_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack);
							if (_entity instanceof Player _player)
								_player.getInventory().setChanged();
						}
					}
				}
				a = (e1 instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				b = (e1 instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY);
				c0 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY);
				c1 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY);
				c2 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY);
				c3 = (e1 instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY);
				a.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				b.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				c0.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				c1.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				c2.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				c3.getOrCreateTag().putBoolean("bukeshiquwupin", true);
				a.enchant(Enchantments.VANISHING_CURSE, 1);
				c0.enchant(Enchantments.VANISHING_CURSE, 1);
				c1.enchant(Enchantments.VANISHING_CURSE, 1);
				c2.enchant(Enchantments.VANISHING_CURSE, 1);
				c3.enchant(Enchantments.VANISHING_CURSE, 1);
				{
					ItemStack _ist = a;
					if (_ist.hurt((int) (a.getMaxDamage() * 0.8), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = c0;
					if (_ist.hurt((int) (c0.getMaxDamage() * 0.8), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = c1;
					if (_ist.hurt((int) (c1.getMaxDamage() * 0.8), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = c2;
					if (_ist.hurt((int) (c2.getMaxDamage() * 0.8), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
				{
					ItemStack _ist = c3;
					if (_ist.hurt((int) (c3.getMaxDamage() * 0.8), RandomSource.create(), null)) {
						_ist.shrink(1);
						_ist.setDamageValue(0);
					}
				}
			}
		}
	}
}
