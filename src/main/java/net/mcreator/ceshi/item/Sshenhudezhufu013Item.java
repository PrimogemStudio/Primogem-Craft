
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Sshenhudezhufu013Item extends RecordItem {
	public Sshenhudezhufu013Item() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:daoqigantiancun013")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}
}
