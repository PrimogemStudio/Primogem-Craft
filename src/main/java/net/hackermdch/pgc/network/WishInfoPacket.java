package net.hackermdch.pgc.network;

import com.google.common.collect.ImmutableSet;
import net.hackermdch.pgc.CustomAPI;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.network.connection.ConnectionType;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

public class WishInfoPacket implements CustomPacketPayload {
    @SuppressWarnings("unchecked")
    public static final Set<ItemLike>[] info = new Set[3];
    private static final Type<WishInfoPacket> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(MODID, "wish_info"));
    private final Set<Holder<Item>> items;
    private final RegistryAccess registry;
    private final int index;

    public WishInfoPacket(Set<Holder<Item>> items, int index, RegistryAccess registry) {
        this.items = items;
        this.index = index;
        this.registry = registry;
    }

    private WishInfoPacket(FriendlyByteBuf buf) {
        registry = CustomAPI.registryAccess();
        index = buf.readInt();
        var size = buf.readInt();
        var codec = ByteBufCodecs.holderRegistry(Registries.ITEM);
        var builder = ImmutableSet.<Holder<Item>>builder();
        var regBuf = new RegistryFriendlyByteBuf(buf, registry, ConnectionType.NEOFORGE);
        for (int i = 0; i < size; i++) builder.add(codec.decode(regBuf));
        items = builder.build();
    }

    private void encode(FriendlyByteBuf buf) {
        buf.writeInt(index);
        buf.writeInt(items.size());
        var regBuf = new RegistryFriendlyByteBuf(buf, registry, ConnectionType.NEOFORGE);
        var codec = ByteBufCodecs.holderRegistry(Registries.ITEM);
        for (Holder<Item> item : items) codec.encode(regBuf, item);
    }

    private void handle(IPayloadContext context) {
        info[index] = items.stream().map(Holder::value).collect(ImmutableSet.toImmutableSet());
    }

    @Override
    @NotNull
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void register(PayloadRegistrar registrar) {
        registrar.configurationToClient(TYPE, StreamCodec.ofMember(WishInfoPacket::encode, WishInfoPacket::new), WishInfoPacket::handle);
    }
}
