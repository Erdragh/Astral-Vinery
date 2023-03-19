package com.github.erdragh.astralvinery.compat.rei.wine_press;

import com.github.erdragh.astralvinery.AstralVinery;
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
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import satisfyu.vinery.VineryIdentifier;
import satisfyu.vinery.registry.ObjectRegistry;

import java.util.List;

public class WinePressCategory implements DisplayCategory<WinePressDisplay> {

    private static final Identifier BG = new VineryIdentifier("textures/gui/wine_press.png");

    private static final int BORDER_WIDTH = 6;
    @Override
    public CategoryIdentifier<? extends WinePressDisplay> getCategoryIdentifier() {
        return REICategories.WINE_PRESS_CATEGORY;
    }

    @Override
    public int getDisplayHeight() {
        return 50 + 2 * BORDER_WIDTH;
    }

    @Override
    public int getDisplayWidth(WinePressDisplay display) {
        return 93 + 2 * BORDER_WIDTH;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("rei." + AstralVinery.MODID + ".wine_press");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ObjectRegistry.WINE_PRESS);
    }

    @Override
    public List<Widget> setupDisplay(WinePressDisplay display, Rectangle bounds) {
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));

        var withinBorders = new Rectangle(bounds.x + BORDER_WIDTH, bounds.y + BORDER_WIDTH, bounds.width - 2 * BORDER_WIDTH, bounds.height - 2 * BORDER_WIDTH);

        widgets.add(Widgets.createTexturedWidget(BG, new Rectangle(withinBorders.x, withinBorders.y, withinBorders.width, withinBorders.height), 44, 17));

        widgets.add(Widgets.createSlot(new Point(withinBorders.x + 4, withinBorders.y + 17)).entries(display.getInputEntries().get(0)).markInput());
        widgets.add(Widgets.createArrow(new Point(withinBorders.x + 34, withinBorders.y + 17)).animationDurationTicks(72));
        widgets.add(Widgets.createSlot(new Point(withinBorders.x + 72, withinBorders.y + 18)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        return widgets;
    }
}
