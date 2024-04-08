
package net.mcreator.ceshi.item;

import net.minecraftforge.registries.ForgeRegistries;

import net.minecraft.world.item.RecordItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;

public class TaikongmanbuchangpianItem extends RecordItem {
	public TaikongmanbuchangpianItem() {
		super(10, () -> ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("primogemcraft:taikongmanbuyinpin")), new Item.Properties().stacksTo(1).rarity(Rarity.RARE), 5000);
	}
}
