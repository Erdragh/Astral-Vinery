package com.github.erdragh.astralvinery.compat.rei.wood_fired_oven;

import com.github.erdragh.astralvinery.compat.rei.REICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import satisfyu.vinery.recipe.WoodFiredOvenRecipe;

import java.util.Collections;
import java.util.List;

public record WoodFiredOvenDisplay(WoodFiredOvenRecipe recipe) implements Display {
    @Override
    public List<EntryIngredient> getInputEntries() {
        return EntryIngredients.ofIngredients(recipe.getIngredients());
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return Collections.singletonList(EntryIngredients.of(recipe.getOutput()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REICategories.WOOD_FIRED_OVEN_CATEGORY;
    }
}
