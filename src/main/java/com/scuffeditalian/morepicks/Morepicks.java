package com.scuffeditalian.morepicks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import com.scuffeditalian.morepicks.itemstacks.*;

import static com.scuffeditalian.morepicks.itemstacks.ExcaliDust;

public final class Morepicks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        itemstacks.ItemInit();
        getCommand("givePick1").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new events(), this);
        //Recipes
        ShapedRecipe sr = new ShapedRecipe(NamespacedKey.minecraft("excpick"), itemstacks.ExcalipickItem);
        sr.shape("EEE", "EPE", "EEE");
        sr.setIngredient('E', new RecipeChoice.ExactChoice(itemstacks.ExcaliDust));
        sr.setIngredient('P', Material.IRON_PICKAXE);
        Bukkit.getServer().addRecipe(sr);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
