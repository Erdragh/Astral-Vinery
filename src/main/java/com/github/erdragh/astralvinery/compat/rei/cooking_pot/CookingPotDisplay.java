package com.github.erdragh.astralvinery.compat.rei.cooking_pot;

import com.github.erdragh.astralvinery.compat.rei.REICategories;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import satisfyu.vinery.recipe.CookingPotRecipe;

import java.util.List;

@Environment(EnvType.CLIENT)
public record CookingPotDisplay(CookingPotRecipe recipe) implements Display {
    @Override
    public List<EntryIngredient> getInputEntries() {
        return EntryIngredients.ofIngredients(recipe.getIngredients());
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(EntryIngredients.of(recipe.getOutput()));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return REICategories.COOKING_POT_CATEGORY;
    }
}