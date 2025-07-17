package org.iopro.limitedFarming;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class Recipes {
    public static void register() {

        /// BAIT RECIPE ///

        ItemStack dirt = new ItemStack(Material.DIRT);
        dirt.setAmount(1);

        // Outline the recipe shape
        ShapelessRecipe dirtRecipe = new ShapelessRecipe(Keys.DIRT_RECIPE, dirt);

        // Now just substitute the ingredients
        dirtRecipe.addIngredient(1, Material.BONE_MEAL);
        dirtRecipe.addIngredient(1, Material.COARSE_DIRT);

        // Don't duplicate recipe
        if (Bukkit.getRecipe(Keys.DIRT_RECIPE) != null) {
            Bukkit.removeRecipe(Keys.DIRT_RECIPE);
        }
        Bukkit.addRecipe(dirtRecipe);
    }
}
