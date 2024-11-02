package net.hackermdch.pgc;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.network.codec.StreamCodec;

public class CustomBar {
    public int numerator, denominator;
    public boolean visible;
    private static int counter = 0;
    private final int id = counter++;

    public CustomBar(int numerator, int denominator, boolean visible) {
        this.numerator = numerator;
        this.denominator = denominator;
        this.visible = visible;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CustomBar bar && id == bar.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    static final Codec<CustomBar> CODEC = RecordCodecBuilder.create(instance -> instance.group(Codec.INT.fieldOf("numerator").forGetter(o -> o.numerator), Codec.INT.fieldOf("denominator").forGetter(o -> o.denominator), Codec.BOOL.fieldOf("visible").forGetter(o -> o.visible)).apply(instance, CustomBar::new));
    static final StreamCodec<ByteBuf, CustomBar> STREAM_CODEC = StreamCodec.of((buf, v) -> {
        buf.writeInt(v.numerator);
        buf.writeInt(v.denominator);
        buf.writeBoolean(v.visible);
    }, buf -> new CustomBar(buf.readInt(), buf.readInt(), buf.readBoolean()));
}
