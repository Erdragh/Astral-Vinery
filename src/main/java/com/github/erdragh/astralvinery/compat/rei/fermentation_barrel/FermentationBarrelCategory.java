package com.github.erdragh.astralvinery.compat.rei.fermentation_barrel;

import com.github.erdragh.astralvinery.compat.rei.REICategories;
import com.google.common.collect.Lists;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import satisfyu.vinery.VineryIdentifier;
import satisfyu.vinery.block.entity.FermentationBarrelBlockEntity;
import satisfyu.vinery.registry.ObjectRegistry;

import java.util.List;

@Environment(EnvType.CLIENT)
public class FermentationBarrelCategory implements DisplayCategory<FermentationBarrelDisplay> {
    public static final Identifier BG = new VineryIdentifier("textures/gui/barrel_gui.png");
    private static final int BORDER_WIDTH = 6;

    @Override
    public CategoryIdentifier<? extends FermentationBarrelDisplay> getCategoryIdentifier() {
        return REICategories.FERMENTATION_BARREL_CATEGORY;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("rei.astralvinery.fermentation_barrel");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ObjectRegistry.FERMENTATION_BARREL);
    }

    @Override
    public int getDisplayHeight() {
        return 52 + 2 * BORDER_WIDTH;
    }

    @Override
    public int getDisplayWidth(FermentationBarrelDisplay display) {
        return 129 + 2 * BORDER_WIDTH;
    }

    @Override
    public List<Widget> setupDisplay(FermentationBarrelDisplay display, Rectangle bounds) {
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        widgets.add(Widgets.createTexturedWidget(BG, new Rectangle(bounds.x + BORDER_WIDTH, bounds.y + BORDER_WIDTH, bounds.width - 2 * BORDER_WIDTH, bounds.height - 2 * BORDER_WIDTH), 13, 15));
        Point withinBorders = new Point(bounds.x + BORDER_WIDTH + 1, bounds.y + BORDER_WIDTH + 1);
        widgets.add(Widgets.createArrow(new Point(withinBorders.x + 75, withinBorders.y + 18)).animationDurationTicks(FermentationBarrelBlockEntity.COOKING_TIME_IN_TICKS));
        widgets.add(Widgets.createSlot(new Point(withinBorders.x + 111, withinBorders.y + 19)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        for (int i = 0; i < 4; i++) {
            int x = i * 18;
            int y = 10;
            if (i > 1) {
                x = (i - 2) * 18;
                y += 18;
            }
            x += 4;
            if (i >= display.getInputEntries().size() - 1) widgets.add(Widgets.createSlotBackground(new Point(withinBorders.x + x, withinBorders.y + y)));
            else widgets.add(Widgets.createSlot(new Point(withinBorders.x + x, withinBorders.y + y)).entries(display.getInputEntries().get(i + 1)).markInput());
        }
        widgets.add(Widgets.createSlot(new Point(withinBorders.x + 49, withinBorders.y + 34)).entries(display.getInputEntries().get(0)).markInput());
        return widgets;
    }
}
