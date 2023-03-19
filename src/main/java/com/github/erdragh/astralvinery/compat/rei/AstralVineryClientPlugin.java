package com.github.erdragh.astralvinery.compat.rei;

import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotCategory;
import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotDisplay;
import com.github.erdragh.astralvinery.compat.rei.fermentation_barrel.FermentationBarrelCategory;
import com.github.erdragh.astralvinery.compat.rei.fermentation_barrel.FermentationBarrelDisplay;
import com.github.erdragh.astralvinery.compat.rei.wood_fired_oven.WoodFiredOvenCategory;
import com.github.erdragh.astralvinery.compat.rei.wood_fired_oven.WoodFiredOvenDisplay;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import satisfyu.vinery.recipe.CookingPotRecipe;
import satisfyu.vinery.recipe.FermentationBarrelRecipe;
import satisfyu.vinery.recipe.WoodFiredOvenRecipe;
import satisfyu.vinery.registry.ObjectRegistry;
import satisfyu.vinery.registry.VineryRecipeTypes;

@Environment(EnvType.CLIENT)
public class AstralVineryClientPlugin implements REIClientPlugin {
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new CookingPotCategory());
        registry.add(new FermentationBarrelCategory());
        registry.add(new WoodFiredOvenCategory());

        registry.addWorkstations(REICategories.COOKING_POT_CATEGORY, EntryStacks.of(ObjectRegistry.COOKING_POT));
        registry.addWorkstations(REICategories.FERMENTATION_BARREL_CATEGORY, EntryStacks.of(ObjectRegistry.FERMENTATION_BARREL));
        registry.addWorkstations(REICategories.WOOD_FIRED_OVEN_CATEGORY, EntryStacks.of(ObjectRegistry.WOOD_FIRED_OVEN));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(CookingPotRecipe.class, VineryRecipeTypes.COOKING_POT_RECIPE_TYPE, CookingPotDisplay::new);
        registry.registerRecipeFiller(FermentationBarrelRecipe.class, VineryRecipeTypes.FERMENTATION_BARREL_RECIPE_TYPE, FermentationBarrelDisplay::new);
        registry.registerRecipeFiller(WoodFiredOvenRecipe.class, VineryRecipeTypes.WOOD_FIRED_OVEN_RECIPE_TYPE, WoodFiredOvenDisplay::new);
    }
}
