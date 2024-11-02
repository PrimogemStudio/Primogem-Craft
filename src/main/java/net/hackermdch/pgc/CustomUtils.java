package net.hackermdch.pgc;

import it.unimi.dsi.fastutil.objects.ObjectArraySet;

import java.util.Set;

public final class CustomUtils {
    public static final Set<String> enableInventoryAttribute = new ObjectArraySet<>();

    public static void enableForInventory(String item) {
        enableInventoryAttribute.add(item);
    }
}
