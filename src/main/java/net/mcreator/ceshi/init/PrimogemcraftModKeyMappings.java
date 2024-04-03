
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.ceshi.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.ceshi.network.ZzkjxgkgMessage;
import net.mcreator.ceshi.PrimogemcraftMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PrimogemcraftModKeyMappings {
	public static final KeyMapping ZZKJXGKG = new KeyMapping("key.primogemcraft.zzkjxgkg", GLFW.GLFW_KEY_UNKNOWN, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PrimogemcraftMod.PACKET_HANDLER.sendToServer(new ZzkjxgkgMessage(0, 0));
				ZzkjxgkgMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ZZKJXGKG);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ZZKJXGKG.consumeClick();
			}
		}
	}
}
