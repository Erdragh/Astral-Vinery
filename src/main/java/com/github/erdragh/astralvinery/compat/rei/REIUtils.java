package com.github.erdragh.astralvinery.compat.rei;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class REIUtils {
    public static List<Ingredient> addIngredient(List<Ingredient> ingredients, ItemStack stack) {
        var copiedList = new ArrayList<>(ingredients);
        copiedList.add(0, Ingredient.ofItems(stack.getItem()));
        return copiedList;
    }
}
