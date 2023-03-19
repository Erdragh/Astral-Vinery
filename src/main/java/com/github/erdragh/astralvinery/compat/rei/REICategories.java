package com.github.erdragh.astralvinery.compat.rei;

import com.github.erdragh.astralvinery.AstralVinery;
import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotDisplay;
import com.github.erdragh.astralvinery.compat.rei.fermentation_barrel.FermentationBarrelDisplay;
import com.github.erdragh.astralvinery.compat.rei.wine_press.WinePressDisplay;
import com.github.erdragh.astralvinery.compat.rei.wood_fired_oven.WoodFiredOvenDisplay;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.util.Identifier;

public class REICategories {
    public static final CategoryIdentifier<CookingPotDisplay> COOKING_POT_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "cooking_pot"));
    public static final CategoryIdentifier<FermentationBarrelDisplay> FERMENTATION_BARREL_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "fermentation_barrel"));
    public static final CategoryIdentifier<WoodFiredOvenDisplay> WOOD_FIRED_OVEN_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "wood_fired_oven"));
    public static final CategoryIdentifier<WinePressDisplay> WINE_PRESS_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "wine_press"));
}
