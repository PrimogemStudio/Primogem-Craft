
package net.mcreator.ceshi.item;

import net.neoforged.neoforge.registries.RegisterEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Holder;
import net.minecraft.Util;

import net.mcreator.ceshi.procedures.RytsxProcedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class RuzstItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 7);
				map.put(ArmorItem.Type.CHESTPLATE, 9);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 9);
			}), 20, DeferredHolder.create(Registries.SOUND_EVENT, new ResourceLocation("item.armor.equip_diamond")), () -> Ingredient.of(new ItemStack(PrimogemcraftModItems.RANYUANSUIXIE.get()), new ItemStack(Items.DIAMOND)),
					List.of(new ArmorMaterial.Layer(new ResourceLocation("primogemcraft:ryzst_"))), 3f, 0.1f);
			registerHelper.register(new ResourceLocation("primogemcraft:ruzst"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public RuzstItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends RuzstItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends RuzstItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends RuzstItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				RytsxProcedure.execute(entity, itemstack);
			}
		}
	}

	public static class Boots extends RuzstItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A77 2x \u63D0\u4F9B\u6C38\u4E45\u6297\u706B\u6548\u679C"));
			list.add(Component.literal("\u00A77 4x \u5BF9\u653B\u51FB\u4F60\u7684\u76EE\u6807\u65BD\u52A0\u7194\u5CA9\u4F24\u5BB3\u548C\u71C3\u70E7"));
			list.add(Component.literal("\u00A78\u4F24\u5BB3\u91CF=10*\u5957\u88C5\u6570\u503C*%\u73A9\u5BB6\u5F53\u524D\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A76\u5355\u4E2A\u751F\u72692\u79D2\u81F3\u591A\u88AB\u53CD\u51FB1\u6B21"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u739B\u7459\uFF09"));
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
