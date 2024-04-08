
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Ccangruimilinjian014Item extends RecordItem {
	public Ccangruimilinjian014Item() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:xumimolazhuang")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}
}
