package net.hackermdch.pgc.rei;

import com.google.common.collect.ImmutableList;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.mcreator.ceshi.init.PrimogemcraftModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

import java.util.List;

import static net.mcreator.ceshi.PrimogemcraftMod.MODID;

@OnlyIn(Dist.CLIENT)
public class ConvertCategory implements DisplayCategory<ConvertDisplay> {
    private static final ResourceLocation texture = ResourceLocation.fromNamespaceAndPath(MODID, "textures/screens/qunxingzhuanhuanqi_sx.png");

    @Override
    public CategoryIdentifier<? extends ConvertDisplay> getCategoryIdentifier() {
        return PGCPlugin.CONVERT;
    }

    @Override
    public List<Widget> setupDisplay(ConvertDisplay display, Rectangle bounds) {
        var widgets = ImmutableList.<Widget>builder();
        var startPoint = new Point(bounds.getCenterX(), bounds.getCenterY());
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createDrawableWidget((graphics, mouseX, mouseY, delta) -> graphics.blit(texture, startPoint.x - 50, startPoint.y - 12, 16, 24, 320, 0, 32, 48, 352, 48)));
        widgets.add(Widgets.createTooltip(new Rectangle(startPoint.x - 50, startPoint.y - 12, 16, 24), Component.translatable("rei.pgc.tooltip.convert", display.cost)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x - 30, startPoint.y - 22)).entries(display.getInputEntries().get(1)).markInput());
        widgets.add(Widgets.createArrow(new Point(startPoint.x - 9, startPoint.y - 23)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 20, startPoint.y - 22)).entries(display.getOutputEntries().getFirst()).markOutput());
        widgets.add(Widgets.createSlot(new Point(startPoint.x - 30, startPoint.y + 8)).entries(display.getInputEntries().get(2)).markInput());
        widgets.add(Widgets.createArrow(new Point(startPoint.x - 9, startPoint.y + 7)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 20, startPoint.y + 8)).entries(display.getOutputEntries().get(1)).markOutput());
        return widgets.build();
    }

    @Override
    public Component getTitle() {
        return Component.translatable("rei.category.pgc.convert");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(PrimogemcraftModItems.QXZHQ);
    }

    @Override
    public int getDisplayHeight() {
        return 63;
    }

    @Override
    public int getDisplayWidth(ConvertDisplay display) {
        return 120;
    }
}
