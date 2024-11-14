package net.hackermdch.pgc;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.IItemDecorator;
import org.jetbrains.annotations.NotNull;

public record CustomBarRender(int offset, int color) implements IItemDecorator {
    @Override
    public boolean render(@NotNull GuiGraphics graphics, @NotNull Font font, @NotNull ItemStack stack, int x, int y) {
        var bar = stack.getOrDefault(CustomComponents.CUSTOM_BAR, new CustomBar(1, 1, false));
        if (bar.visible) {
            var degree = (int) Math.min(13, bar.numerator / (float) bar.denominator * 13);
            graphics.fill(RenderType.guiOverlay(), x + 2, y + offset, x + 15, y + offset + 2, 0xff000000);
            graphics.fill(RenderType.guiOverlay(), x + 2, y + offset, x + 2 + degree, y + offset + 1, color | 0xff000000);
            return true;
        }
        return false;
    }
}
