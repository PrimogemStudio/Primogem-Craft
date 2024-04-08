
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Xiwangdeyitian011Item extends RecordItem {
	public Xiwangdeyitian011Item() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:mengdeyewai011")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}
}
