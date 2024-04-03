
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import java.util.List;

public class Sshenhudezhufu013Item extends RecordItem {
	public Sshenhudezhufu013Item() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:daoqigantiancun013")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}
}
