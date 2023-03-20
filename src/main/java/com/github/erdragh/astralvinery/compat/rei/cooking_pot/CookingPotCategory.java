package com.github.erdragh.astralvinery.compat.rei.cooking_pot;

import com.github.erdragh.astralvinery.AstralVinery;
import com.github.erdragh.astralvinery.compat.rei.REICategories;
import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
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
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import satisfyu.vinery.VineryIdentifier;
import satisfyu.vinery.block.entity.CookingPotEntity;
import satisfyu.vinery.registry.ObjectRegistry;

import java.util.ArrayList;
import java.util.List;

@Environment(EnvType.CLIENT)
public class CookingPotCategory implements DisplayCategory<CookingPotDisplay> {
    public static final Identifier BG = new VineryIdentifier("textures/gui/pot_gui.png");

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ObjectRegistry.COOKING_POT);
    }
    @Override
    public Text getTitle() {
        return new TranslatableText("rei.astralvinery.cooking_pot");
    }

    @Override
    public CategoryIdentifier<? extends CookingPotDisplay> getCategoryIdentifier() {
        return REICategories.COOKING_POT_CATEGORY;
    }

    @Override
    public int getDisplayHeight() {
        return 60 + 4;
    }

    @Override
    public int getDisplayWidth(CookingPotDisplay display) {
        return 123 + 4;
    }

    @Override
    public List<Widget> setupDisplay(CookingPotDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 55, bounds.getCenterY() - 13);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));
        //widgets.add(Widgets.createResultSlotBackground(new Point(startPoint.x + 90, startPoint.y)));
        widgets.add(Widgets.createTexturedWidget(BG, new Rectangle(bounds.x + 4, bounds.y + 4, bounds.width - 8, bounds.height - 8), 29, 16));
        widgets.add(Widgets.createArrow(new Point(bounds.x + 60 + 4, bounds.y + 10 + 4)).animationDurationTicks(CookingPotEntity.MAX_COOKING_TIME));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 91, startPoint.y - 3)).entries(display.getOutputEntries().get(0)).disableBackground().markOutput());
        for(int i = 0; i < 6; i++){
            int x = i * 18;
            int y = 5;
            if(i > 2){
                x = (i - 3) * 18;
                y+=18;
            }
            x+=5;
            if(i >= display.getInputEntries().size() - 1) widgets.add(Widgets.createSlotBackground(new Point(bounds.x + x, bounds.y + y)));
            else widgets.add(Widgets.createSlot(new Point(bounds.x + x, bounds.y + y)).entries(display.getInputEntries().get(i + 1)).markInput());
        }
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 59, startPoint.y + 24)).entries(display.getInputEntries().get(0)).markInput());
        return widgets;
    }
}
