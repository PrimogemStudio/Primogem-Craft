package net.hackermdch.pgc;

import net.minecraft.core.component.DataComponentType;

public class CustomComponents {
    public static final DataComponentType<CustomBar> CUSTOM_BAR = DataComponentType.<CustomBar>builder().persistent(CustomBar.CODEC).networkSynchronized(CustomBar.STREAM_CODEC).build();
}
