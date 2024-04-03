
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.ZskjsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

import com.google.common.collect.Iterables;

public abstract class ZshjtItem extends ArmorItem {
	public ZshjtItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 200;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{5, 6, 8, 5}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 15;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PrimogemcraftModItems.ZUISHENGDUANPIAN.get()), new ItemStack(Items.NETHERITE_INGOT));
			}

			@Override
			public String getName() {
				return "zshjt";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	public static class Helmet extends ZshjtItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u52FE\u7389\u72B6\u6001\u4E0B\u83B7\u5F97\u9AD8\u989D\u6297\u6027\u63D0\u5347"));
			list.add(Component.literal("\u00A77 4x \u96E8\u6216\u96F7\u96E8\u5929\u83B7\u5F97\u529B\u91CF \u901F\u5EA6"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u7D2B\u91D1\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/zshjt__layer_1.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				ZskjsxProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Chestplate extends ZshjtItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u52FE\u7389\u72B6\u6001\u4E0B\u83B7\u5F97\u9AD8\u989D\u6297\u6027\u63D0\u5347"));
			list.add(Component.literal("\u00A77 4x \u96E8\u6216\u96F7\u96E8\u5929\u83B7\u5F97\u529B\u91CF \u901F\u5EA6"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u7D2B\u91D1\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/zshjt__layer_1.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				ZskjsxProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Leggings extends ZshjtItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u52FE\u7389\u72B6\u6001\u4E0B\u83B7\u5F97\u9AD8\u989D\u6297\u6027\u63D0\u5347"));
			list.add(Component.literal("\u00A77 4x \u96E8\u6216\u96F7\u96E8\u5929\u83B7\u5F97\u529B\u91CF \u901F\u5EA6"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u7D2B\u91D1\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/zshjt__layer_2.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				ZskjsxProcedure.execute(world, entity, itemstack);
			}
		}
	}

	public static class Boots extends ZshjtItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, world, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u52FE\u7389\u72B6\u6001\u4E0B\u83B7\u5F97\u9AD8\u989D\u6297\u6027\u63D0\u5347"));
			list.add(Component.literal("\u00A77 4x \u96E8\u6216\u96F7\u96E8\u5929\u83B7\u5F97\u529B\u91CF \u901F\u5EA6"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u7D2B\u91D1\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/zshjt__layer_1.png";
		}

		@Override
		public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
			return false;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				ZskjsxProcedure.execute(world, entity, itemstack);
			}
		}
	}
}
