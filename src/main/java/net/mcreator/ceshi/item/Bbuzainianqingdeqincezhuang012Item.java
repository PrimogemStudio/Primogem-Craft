
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class Bbuzainianqingdeqincezhuang012Item extends RecordItem {
	public Bbuzainianqingdeqincezhuang012Item() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:liyueqincezhuang012")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}
}
