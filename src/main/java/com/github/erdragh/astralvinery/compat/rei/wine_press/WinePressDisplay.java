package com.github.erdragh.astralvinery.compat.rei.wine_press;

import com.github.erdragh.astralvinery.compat.rei.REICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.item.Items;
import satisfyu.vinery.registry.ObjectRegistry;

import java.util.Collections;
import java.util.List;

public class WinePressDisplay implements Display {

    @Override
    public List<EntryIngredient> getInputEntries() {
        return Collections.singletonList(EntryIngredients.of(Items.APPLE));
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return Collections.singletonList(EntryIngredients.of(ObjectRegistry.APPLE_MASH));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REICategories.WINE_PRESS_CATEGORY;
    }
}
