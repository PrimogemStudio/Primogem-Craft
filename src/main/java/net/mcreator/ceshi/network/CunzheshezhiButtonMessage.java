
package net.mcreator.ceshi.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.ceshi.world.inventory.CunzheshezhiMenu;
import net.mcreator.ceshi.procedures.GUIsxr1Procedure;
import net.mcreator.ceshi.procedures.GUIsxr10Procedure;
import net.mcreator.ceshi.procedures.GUIsxr100Procedure;
import net.mcreator.ceshi.procedures.GUIsxp1Procedure;
import net.mcreator.ceshi.procedures.GUIsxp10Procedure;
import net.mcreator.ceshi.procedures.GUIsxp100Procedure;
import net.mcreator.ceshi.procedures.CunzheshuxingProcedure;
import net.mcreator.ceshi.procedures.Cunzheshuxing3Procedure;
import net.mcreator.ceshi.procedures.Cunzheshuxing2Procedure;
import net.mcreator.ceshi.procedures.Cunzheshuxing02Procedure;
import net.mcreator.ceshi.procedures.CunzheguibwdProcedure;
import net.mcreator.ceshi.PrimogemcraftMod;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record CunzheshezhiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<CunzheshezhiButtonMessage> TYPE = new Type<>(new ResourceLocation(PrimogemcraftMod.MODID, "cunzheshezhi_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CunzheshezhiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CunzheshezhiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CunzheshezhiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<CunzheshezhiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CunzheshezhiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CunzheshezhiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Cunzheshuxing02Procedure.execute(entity);
		}
		if (buttonID == 1) {

			GUIsxp1Procedure.execute(entity, guistate);
		}
		if (buttonID == 2) {

			GUIsxp10Procedure.execute(entity, guistate);
		}
		if (buttonID == 3) {

			GUIsxp100Procedure.execute(entity, guistate);
		}
		if (buttonID == 4) {

			GUIsxr1Procedure.execute(entity, guistate);
		}
		if (buttonID == 5) {

			GUIsxr10Procedure.execute(entity, guistate);
		}
		if (buttonID == 6) {

			GUIsxr100Procedure.execute(entity, guistate);
		}
		if (buttonID == 7) {

			CunzheshuxingProcedure.execute(entity, guistate);
		}
		if (buttonID == 8) {

			Cunzheshuxing3Procedure.execute(entity, guistate);
		}
		if (buttonID == 9) {

			CunzheguibwdProcedure.execute(entity);
		}
		if (buttonID == 10) {

			Cunzheshuxing2Procedure.execute(entity, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PrimogemcraftMod.addNetworkMessage(CunzheshezhiButtonMessage.TYPE, CunzheshezhiButtonMessage.STREAM_CODEC, CunzheshezhiButtonMessage::handleData);
	}
}
