package com.scuffeditalian.morepicks;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import com.scuffeditalian.morepicks.itemstacks.*;

import static com.scuffeditalian.morepicks.itemstacks.*;

public final class Morepicks extends JavaPlugin {
    private static Morepicks instance;
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        itemstacks.ItemInit();
        getCommand("GiveAllPicks").setExecutor(new commands());
        getCommand("GiveAllDusts").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new events(), this);
        //Recipes
        ShapedRecipe sr1 = new ShapedRecipe(NamespacedKey.minecraft("excpick"), itemstacks.ExcalipickItem);
        sr1.shape("EEE", "EPE", "EEE");
        sr1.setIngredient('E', new RecipeChoice.ExactChoice(itemstacks.ExcaliDust));
        sr1.setIngredient('P', Material.IRON_PICKAXE);
        Bukkit.getServer().addRecipe(sr1);

        ShapedRecipe sr2 = new ShapedRecipe(NamespacedKey.minecraft("mithdust"), itemstacks.MithoDust);
        sr2.shape("DDD","DDD","DDD");
        sr2.setIngredient('D', new RecipeChoice.ExactChoice(ExcaliDust));
        Bukkit.getServer().addRecipe(sr2);

        ShapedRecipe sr3 = new ShapedRecipe(NamespacedKey.minecraft("expick2k"), itemstacks.EscaliPickItem2);
        sr3.shape("MMM","MPM","MMM");
        sr3.setIngredient('M', new RecipeChoice.ExactChoice(MithoDust));
        sr3.setIngredient('P', new RecipeChoice.ExactChoice(ExcalipickItem));
        Bukkit.getServer().addRecipe(sr3);


    }
    public static Morepicks getInstance() {
        return instance;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
