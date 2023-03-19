package com.github.erdragh.astralvinery.compat.rei;

import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotCategory;
import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotDisplay;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import satisfyu.vinery.Vinery;
import satisfyu.vinery.recipe.CookingPotRecipe;
import satisfyu.vinery.registry.ObjectRegistry;
import satisfyu.vinery.registry.VineryMaterials;
import satisfyu.vinery.registry.VineryRecipeTypes;

@Environment(EnvType.CLIENT)
public class AstralVineryClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CookingPotCategory());

        registry.addWorkstations(REICategories.COOKING_POT_CATEGORY, EntryStacks.of(ObjectRegistry.COOKING_POT));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CookingPotRecipe.class, VineryRecipeTypes.COOKING_POT_RECIPE_TYPE, CookingPotDisplay::new);
    }
}
