package net.mcreator.ceshi.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.ceshi.init.PrimogemcraftModItems;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class Ccpzsx2Procedure {
	@SubscribeEvent
	public static void onPickup(EntityItemPickupEvent event) {
		execute(event, event.getEntity(), event.getItem().getItem());
	}

	public static void execute(Entity entity, ItemStack itemstack) {
		execute(null, entity, itemstack);
	}

	private static void execute(@Nullable Event event, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (itemstack.getItem() == PrimogemcraftModItems.CUNQUPINGZHENG.get()) {
			if (entity.getPersistentData().getBoolean("pgc_cunchu_shue") && entity.getPersistentData().getBoolean("bwd_yinhang") && !itemstack.getOrCreateTag().getBoolean("pgc_cunchu")) {
				itemstack.getOrCreateTag().putDouble("pgc_cunchu", (entity.getPersistentData().getDouble("pgc_cunchu_shue")));
				itemstack.getOrCreateTag().putBoolean("bwd_yinhang", true);
				entity.getPersistentData().putBoolean("pgc_cunchu_shue", false);
				entity.getPersistentData().putBoolean("bwd_yinhang", false);
				itemstack.setHoverName(Component.literal("\u00A7e\u00A7kbw\u00A7e\u5B58\u53D6\u51ED...\u8BC1\uFF1F\u00A7kwd"));
			} else if (entity.getPersistentData().getBoolean("pgc_cunchu_shue") && !entity.getPersistentData().getBoolean("bwd_yinhang") && !itemstack.getOrCreateTag().getBoolean("pgc_cunchu")) {
				itemstack.getOrCreateTag().putDouble("pgc_cunchu", (entity.getPersistentData().getDouble("pgc_cunchu_shue")));
				entity.getPersistentData().putBoolean("pgc_cunchu_shue", false);
			}
		}
	}
}
