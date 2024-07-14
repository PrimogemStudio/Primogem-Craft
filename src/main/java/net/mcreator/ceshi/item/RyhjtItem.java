
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
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.procedures.RytsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;

import com.google.common.collect.Iterables;

public abstract class RyhjtItem extends ArmorItem {
	public RyhjtItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 233;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{5, 7, 9, 5}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 10;
			}

			@Override
			public SoundEvent getEquipSound() {
				return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_netherite"));
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PrimogemcraftModItems.RANYUANDUANPIAN.get()), new ItemStack(Items.NETHERITE_INGOT));
			}

			@Override
			public String getName() {
				return "ryhjt";
			}

			@Override
			public float getToughness() {
				return 1f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.2f;
			}
		}, type, properties);
	}

	public static class Helmet extends RyhjtItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/ryhjt__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends RyhjtItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/ryhjt__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends RyhjtItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/ryhjt__layer_2.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Boots extends RyhjtItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());
		}

		@Override
		public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, level, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+2 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "primogemcraft:textures/models/armor/ryhjt__layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}
}
