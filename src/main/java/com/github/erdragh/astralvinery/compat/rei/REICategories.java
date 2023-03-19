package com.github.erdragh.astralvinery.compat.rei;

import com.github.erdragh.astralvinery.AstralVinery;
import com.github.erdragh.astralvinery.compat.rei.cooking_pot.CookingPotDisplay;
import com.github.erdragh.astralvinery.compat.rei.fermentation_barrel.FermentationBarrelDisplay;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import net.minecraft.util.Identifier;

public class REICategories {
    public static final CategoryIdentifier<CookingPotDisplay> COOKING_POT_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "cooking_pot"));
    public static final CategoryIdentifier<FermentationBarrelDisplay> FERMENTATION_BARREL_CATEGORY = CategoryIdentifier.of(new Identifier(AstralVinery.MODID, "fermentation_barrel"));
}
