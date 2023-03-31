package com.scuffeditalian.morepicks;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class itemstacks {

    public static ItemStack ExcalipickItem;
    public static ItemStack ExcaliDust;
    public static void ItemInit() {
        ExcaliPick_Create();
        ExcaliDust_Create();
    }



    private static void ExcaliDust_Create() {
        ExcaliDust = new ItemStack(Material.GUNPOWDER, 1);
        ItemMeta meta = ExcaliDust.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "ExcaliDust");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "A rare and ancient form of dust...");
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "1/50 Drop!");
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setLore(lore);
        ExcaliDust.setItemMeta(meta);
    }

    private static void ExcaliPick_Create() {
        ExcalipickItem = new ItemStack(Material.IRON_PICKAXE, 1);
        ItemMeta meta = ExcalipickItem.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 1000");
        ExcalipickItem.setItemMeta(meta);

        //Recep


    }
}
