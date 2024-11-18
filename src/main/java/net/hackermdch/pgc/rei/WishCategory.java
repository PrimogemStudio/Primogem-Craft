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
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.joml.Quaternionf;
import org.joml.Vector3f;

import java.util.List;

@OnlyIn(Dist.CLIENT)
public class WishCategory implements DisplayCategory<WishDisplay> {
    @Override
    public CategoryIdentifier<? extends WishDisplay> getCategoryIdentifier() {
        return PGCPlugin.WISH;
    }

    @SuppressWarnings("DataFlowIssue")
    @Override
    public List<Widget> setupDisplay(WishDisplay display, Rectangle bounds) {
        var widgets = ImmutableList.<Widget>builder();
        var startPoint = new Point(bounds.getCenterX() - 58, bounds.getCenterY() - 8);
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createDrawableWidget(((graphics, mouseX, mouseY, delta) -> InventoryScreen.renderEntityInInventory(graphics, startPoint.x + 10, startPoint.y, 30, new Vector3f(), new Quaternionf(), new Quaternionf(), display.entityType.create(Minecraft.getInstance().level)))));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 95, startPoint.y)).entries(display.getOutputEntries().getFirst()).markOutput());
        return widgets.build();
    }

    @Override
    public Component getTitle() {
        return Component.translatable("rei.category.pgc.wish");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(PrimogemcraftModItems.JIJIUCHANZHIYUAN);
    }
}