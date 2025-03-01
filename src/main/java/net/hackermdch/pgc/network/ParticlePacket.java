package net.hackermdch.pgc.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.FireworkParticles;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.component.FireworkExplosion;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class ParticlePacket implements CustomPacketPayload {
    private static final Type<ParticlePacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MODID, "custom_particle"));
    private final int particle;
    private final double x, y, z;

    public ParticlePacket(int particle, double x, double y, double z) {
        this.particle = particle;
        this.x = x;
        this.y = y;
        this.z = z;
    }

    private ParticlePacket(FriendlyByteBuf buf) {
        particle = buf.readInt();
        x = buf.readDouble();
        y = buf.readDouble();
        z = buf.readDouble();
    }

    private void encode(FriendlyByteBuf buf) {
        buf.writeInt(particle);
        buf.writeDouble(x);
        buf.writeDouble(y);
        buf.writeDouble(z);
    }

    @SuppressWarnings("DataFlowIssue")
    @OnlyIn(Dist.CLIENT)
    private void handle(IPayloadContext context) {
        switch (particle) {
            case 0 -> {
                var colors = it.unimi.dsi.fastutil.ints.IntList.of(0xFF9FE0, 0xAEEDFF);
                var fadeColors = it.unimi.dsi.fastutil.ints.IntList.of(0xF4C6FF);
                var pt = new FireworkParticles.Starter(Minecraft.getInstance().level, x, y, z, 0, 0, 0, Minecraft.getInstance().particleEngine, List.of(FireworkExplosion.DEFAULT));
                pt.createParticleBall(0.5, 3, colors, fadeColors, true, false);
            }
            case 1 -> {
                var colors = it.unimi.dsi.fastutil.ints.IntList.of(0xFF9FE0, 0xAEEDFF, 0xF4C6FF);
                var fadeColors = it.unimi.dsi.fastutil.ints.IntList.of();
                var pt = new FireworkParticles.Starter(Minecraft.getInstance().level, x, y, z, 0, 0, 0, Minecraft.getInstance().particleEngine, List.of(FireworkExplosion.DEFAULT));
                pt.createParticleBall(0.5, 5, colors, fadeColors, true, true);
            }
        }
    }

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void register(PayloadRegistrar registrar) {
        registrar.playToClient(TYPE, StreamCodec.ofMember(ParticlePacket::encode, ParticlePacket::new), ParticlePacket::handle);
    }
}
