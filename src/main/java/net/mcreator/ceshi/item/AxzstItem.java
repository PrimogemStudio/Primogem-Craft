
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

import net.mcreator.ceshi.procedures.Axtsx4Procedure;
import net.mcreator.ceshi.procedures.Axtsx3Procedure;
import net.mcreator.ceshi.procedures.Axtsx2Procedure;
import net.mcreator.ceshi.procedures.Axtsx1Procedure;
import net.mcreator.ceshi.init.PrimogemcraftModItems;

import java.util.List;
import java.util.EnumMap;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class AxzstItem extends ArmorItem {
	public static Holder<ArmorMaterial> ARMOR_MATERIAL = null;

	@SubscribeEvent
	public static void registerArmorMaterial(RegisterEvent event) {
		event.register(Registries.ARMOR_MATERIAL, registerHelper -> {
			ArmorMaterial armorMaterial = new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
				map.put(ArmorItem.Type.BOOTS, 4);
				map.put(ArmorItem.Type.LEGGINGS, 6);
				map.put(ArmorItem.Type.CHESTPLATE, 7);
				map.put(ArmorItem.Type.HELMET, 4);
				map.put(ArmorItem.Type.BODY, 7);
			}), 9, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_diamond")), () -> Ingredient.of(new ItemStack(PrimogemcraftModItems.AIXUBINGYUSUIXIE.get()), new ItemStack(Items.DIAMOND)),
					List.of(new ArmorMaterial.Layer(ResourceLocation.parse("primogemcraft:axzst_"))), 2f, 0.1f);
			registerHelper.register(ResourceLocation.parse("primogemcraft:axzst"), armorMaterial);
			ARMOR_MATERIAL = BuiltInRegistries.ARMOR_MATERIAL.wrapAsHolder(armorMaterial);
		});
	}

	public AxzstItem(ArmorItem.Type type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Helmet extends AxzstItem {
		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u624B\u6301\u9539\u65F6\u63D0\u4F9B\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A7b \u2022 \u00A774x \u95F4\u6B47\u6027\u6062\u590D\u5C11\u91CF\u751F\u547D\u503C"));
			list.add(Component.literal("\u00A7c \u2022 \u00A772x \u63D0\u4F9B\u707C\u70E7\u53CD\u51FB\u6548\u679C"));
			list.add(Component.literal("\u00A7c\u4E0D\u6EE1\u8DB3\u6761\u4EF6\u65F6\u5C06\u53D6\u6D88\u589E\u76CA"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u51B0\u7389\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx1Procedure.execute(entity, itemstack);
			}
		}
	}

	public static class Chestplate extends AxzstItem {
		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u624B\u6301\u9550\u65F6\u63D0\u4F9B\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A7e \u2022 \u00A772x \u95F4\u6B47\u6027\u63D0\u4F9B\u5C11\u91CF\u4F24\u5BB3\u5438\u6536"));
			list.add(Component.literal("\u00A7a \u2022 \u00A772x \u63D0\u5347\u5C11\u91CF\u751F\u547D\u503C\u4E0A\u9650"));
			list.add(Component.literal("\u00A7c\u4E0D\u6EE1\u8DB3\u6761\u4EF6\u65F6\u5C06\u53D6\u6D88\u589E\u76CA"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u51B0\u7389\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx2Procedure.execute(entity, itemstack);
			}
		}
	}

	public static class Leggings extends AxzstItem {
		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u624B\u6301\u5251\u65F6\u63D0\u4F9B\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A7d \u2022 \u00A772x \u96E8\u6216\u96F7\u96E8\u5929\u83B7\u5F97\u5C11\u91CF\u529B\u91CF\u548C\u901F\u5EA6\u7684\u589E\u76CA"));
			list.add(Component.literal("\u00A7f \u2022 \u00A772x \u00A7kbuzhidaoxiesha"));
			list.add(Component.literal("\u00A7c\u4E0D\u6EE1\u8DB3\u6761\u4EF6\u65F6\u5C06\u53D6\u6D88\u589E\u76CA"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u51B0\u7389\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx3Procedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, itemstack);
			}
		}
	}

	public static class Boots extends AxzstItem {
		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(117)).fireResistant());
		}

		@Override
		@OnlyIn(Dist.CLIENT)
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, List<Component> list, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, list, flag);
			list.add(Component.literal("\u00A76\u624B\u6301\u65A7\u65F6\u63D0\u4F9B\u5957\u88C5\u6548\u679C\uFF1A"));
			list.add(Component.literal("\u00A7b \u2022 \u00A772x \u514D\u75AB\u7F13\u6162\u6548\u679C"));
			list.add(Component.literal("\u00A7a \u2022 \u00A772x \u83B7\u5F97\u8DF3\u8DC3\u63D0\u5347\u589E\u76CA"));
			list.add(Component.literal("\u00A7c\u4E0D\u6EE1\u8DB3\u6761\u4EF6\u65F6\u5C06\u53D6\u6D88\u589E\u76CA"));
			list.add(Component.literal("\u00A78\u63D0\u5347\u7A0B\u5EA6\u57FA\u4E8E\u5957\u88C5\u503C"));
			list.add(Component.literal("\u00A7"));
			list.add(Component.literal("\u00A79+1 \u5957\u88C5\u503C\uFF08\u51B0\u7389\uFF09"));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				Axtsx4Procedure.execute(entity, itemstack);
			}
		}
	}
}
