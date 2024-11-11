package net.hackermdch.pgc;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class CustomAPI {
    static final Map<Item, CustomBar> defaults = new HashMap<>();

    public static CustomBar getCustomBar(ItemStack stack) {
        var bar = stack.get(CustomComponents.CUSTOM_BAR);
        if (defaults.get(stack.getItem()).equals(bar)) {
            bar = new CustomBar(bar.numerator, bar.denominator, bar.visible);
            stack.set(CustomComponents.CUSTOM_BAR, bar);
        }
        return bar;
    }

    public static boolean hasCustomBar(ItemStack stack) {
        return stack.has(CustomComponents.CUSTOM_BAR);
    }

    public static AttributeWrapper getAttributes(ItemStack stack) {
        return new AttributeWrapper(stack);
    }
}
