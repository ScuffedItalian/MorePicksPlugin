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
    public static ItemStack MithoDust;
    public static ItemStack EscaliPickItem2;
    public static ItemStack TerraDust;
    public static void ItemInit() {
        ExcaliPick_Create();
        ExcaliDust_Create();
        MithoDust_Create();
        ExcaliPick2_Create();
        TerraDust_Create();
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
        List<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "This pickaxe has lots of history...");
        lore2.add("");
        lore2.add(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Excalibur VI");
        lore2.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "???" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        lore2.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "???" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        lore2.add(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.RED + "???" + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        lore2.add("");
        lore2.add(ChatColor.DARK_GREEN + "Ability ->" + ChatColor.GREEN + " Excavation (RIGHT CLICK)");
        lore2.add(ChatColor.GRAY + "Gain Haste 2 for 80 Seconds!");
        lore2.add(ChatColor.GRAY + "Cooldown: 200 Seconds");
        meta.setLore(lore2);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        ExcalipickItem.setItemMeta(meta);
    }

    private static void MithoDust_Create() {
        MithoDust = new ItemStack(Material.GREEN_DYE, 1);
        ItemMeta meta = MithoDust.getItemMeta();

        //Meta
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Mitho Dust");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "fine crafted dust, used to make special tools...");
        lore.add("");
        lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "Legendary Dust");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        MithoDust.setItemMeta(meta);
    }

    private static void ExcaliPick2_Create() {
        EscaliPickItem2 = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta meta = EscaliPickItem2.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 2000");
        List<String> lore2 = new ArrayList<String>();
        lore2.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "This pickaxe has lots of history...");
        lore2.add("");
        lore2.add(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Excalibur V");
        lore2.add(ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "Lucky Finds II");
        lore2.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.LIGHT_PURPLE + "???" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        lore2.add(ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.RED + "???" + ChatColor.RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        lore2.add("");
        lore2.add(ChatColor.AQUA + "" + ChatColor.BOLD + "✯ Gain a 5% chance to drop enchanted diamond when mining diamond!");
        lore2.add("");
        lore2.add(ChatColor.DARK_GREEN + "Ability ->" + ChatColor.GREEN + " Explosion (RIGHT CLICK)");
        lore2.add(ChatColor.GRAY + "Destroy nearby blocks via an explosion");
        lore2.add(ChatColor.GRAY + "Cooldown: 50 Seconds");
        meta.setLore(lore2);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.addEnchant(Enchantment.LUCK, 1, true);

        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        EscaliPickItem2.setItemMeta(meta);
    }

    private static void TerraDust_Create() {
        TerraDust = new ItemStack(Material.REDSTONE, 1);
        ItemMeta meta = TerraDust.getItemMeta();
        meta.setDisplayName( ChatColor.DARK_RED + "" + ChatColor.BOLD + "" + ChatColor.MAGIC + "E" + ChatColor.BOLD + "" + ChatColor.DARK_RED + " Terra's  Dust " + ChatColor.BOLD + "" + ChatColor.MAGIC + "E");
        List<String> lore = new ArrayList<String>();
        lore.add(ChatColor.BOLD + "" + ChatColor.GOLD + "" + ChatColor.BOLD + "Most refined dust...");
        lore.add(ChatColor.DARK_RED + "Used to craft Terra's Pickaxe");
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "1/10K drop!");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        TerraDust.setItemMeta(meta);
    }


}
