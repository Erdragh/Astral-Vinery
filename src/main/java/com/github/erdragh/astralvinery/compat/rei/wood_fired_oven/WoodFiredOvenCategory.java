package com.github.erdragh.astralvinery.compat.rei.wood_fired_oven;

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
import satisfyu.vinery.block.entity.WoodFiredOvenBlockEntity;
import satisfyu.vinery.registry.ObjectRegistry;

import java.text.DecimalFormat;
import java.util.List;

public class WoodFiredOvenCategory implements DisplayCategory<WoodFiredOvenDisplay> {

    private final Identifier BG = new VineryIdentifier("textures/gui/stove_gui.png");

    private final int BORDER_WIDTH = 6;

    @Override
    public int getDisplayHeight() {
        return 49 + 2 * BORDER_WIDTH;
    }

    @Override
    public int getDisplayWidth(WoodFiredOvenDisplay display) {
        return 3 * 18 + 3 + 22 + 3 + 28 + 2 * BORDER_WIDTH;
    }

    @Override
    public List<Widget> setupDisplay(WoodFiredOvenDisplay display, Rectangle bounds) {
        int cookingTime = WoodFiredOvenBlockEntity.TOTAL_COOKING_TIME;
        List<Widget> widgets = Lists.newArrayList();
        widgets.add(Widgets.createRecipeBase(bounds));
        DecimalFormat df = new DecimalFormat("###.##");
        widgets.add(Widgets.createLabel(new Point(bounds.x + bounds.width - 5, bounds.y + 5), new TranslatableText("category.rei.cooking.time&xp", df.format(display.recipe().getExperience()), df.format(cookingTime / 20d))).noShadow().rightAligned().color(0xFF404040, 0xFFBBBBBB));

        var inputs = display.getInputEntries();

        var withinBorders = new Rectangle(bounds.x + BORDER_WIDTH + 1, bounds.y + BORDER_WIDTH + 1, bounds.width - 2 * BORDER_WIDTH, bounds.height - 2 * BORDER_WIDTH);

        // move down the widgets a bit, so they don't clash with the text above as hard
        withinBorders.y += 4;

        int leftHeight = 18 + 15;
        int leftWidth = 3 * 18;

        // centers the widgets on the left vertically
        var leftBase = new Point(withinBorders.x, withinBorders.y + (withinBorders.height - leftHeight) / 2);

        for (int x = 0; x < 3; x++) {
            Point p = new Point(leftBase.x + x * 18, leftBase.y);
            if (inputs.size() > x) {
                widgets.add(Widgets.createSlot(p).entries(inputs.get(x)).markInput());
            } else {
                widgets.add(Widgets.createSlotBackground(p));
            }
        }

        widgets.add(Widgets.createBurningFire(new Point(leftBase.x + 1.5 * 18 - 8, leftBase.y + 18)).animationDurationTicks(500));

        // the -2 is done, because the arrow for some reason starts 2 pixels to the right of where its coordinates are
        widgets.add(Widgets.createArrow(new Point(withinBorders.x + leftWidth + 3 - 2, withinBorders.y + (withinBorders.height - 16) / 2)).animationDurationTicks(cookingTime));
        widgets.add(Widgets.createTexturedWidget(BG, new Rectangle(withinBorders.x + leftWidth + 3 - 2 + 22 + 3 + 1, withinBorders.y + (withinBorders.height - 26) / 2, 28, 26), 110, 30));
        widgets.add(Widgets.createSlot(new Point(withinBorders.x + leftWidth + 3 - 2 + 22 + 3 + 7, withinBorders.y + (withinBorders.height - 18) / 2 + 1)).entries(display.getOutputEntries().get(0)).markOutput().disableBackground());
        return widgets;
    }

    @Override
    public CategoryIdentifier<? extends WoodFiredOvenDisplay> getCategoryIdentifier() {
        return REICategories.WOOD_FIRED_OVEN_CATEGORY;
    }

    @Override
    public Text getTitle() {
        return new TranslatableText("rei.astralvinery.wood_fired_oven");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ObjectRegistry.WOOD_FIRED_OVEN);
    }


}
