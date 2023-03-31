package com.scuffeditalian.morepicks;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class events implements Listener {
    Morepicks plugin = Morepicks.getInstance();

    @EventHandler
    public void BlockBreakHandler(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if(player != null && player.getItemInHand() != null && player.getItemInHand().getItemMeta() != null && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 2000")) {
            if(event.getBlock().getType() == Material.DIAMOND_ORE) {
                ItemStack enchDia = new ItemStack(Material.DIAMOND, 1);
                ItemMeta meta = enchDia.getItemMeta();
                meta.addEnchant(Enchantment.LUCK, 1, true);
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                List<String> lore = new ArrayList<String>();
                lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "a new form of diamond...");
                lore.add("");
                lore.add(ChatColor.LIGHT_PURPLE + "1/1000 drop!");
                meta.setLore(lore);
                enchDia.setItemMeta(meta);
                Random random = new Random();
                int randNum = random.nextInt(1001);
                boolean shouldExecute = randNum <= 5;
                if(shouldExecute) {
                    event.getPlayer().sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Rare Drop! " + ChatColor.AQUA + randNum + "%");
                    event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), enchDia);
                }

            }
            if(event.getBlock().getType() == Material.BROWN_TERRACOTTA) {
                Random random2 = new Random();
                int randNum2 = random2.nextInt(10001);
                boolean shouldEx = randNum2 <= 15;
                if(shouldEx) {
                    event.getBlock().getLocation().getWorld().dropItemNaturally(event.getBlock().getLocation(), itemstacks.TerraDust);
                    event.getPlayer().sendTitle(ChatColor.LIGHT_PURPLE + "RARE DROP!", "E");
                }
            }
        }
    }
    @EventHandler
    public void EntityHandler(EntityDeathEvent event) {

        Entity entity = event.getEntity();
        if (entity.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
            EntityDamageByEntityEvent damageEvent = (EntityDamageByEntityEvent) entity.getLastDamageCause();
            if (damageEvent.getDamager() instanceof Player) {
                Player player = (Player) damageEvent.getDamager();
                Random random = new Random();

                int randomNumber = random.nextInt(51);

                if (randomNumber == 12) {
                    event.getDrops().add(itemstacks.ExcaliDust);
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E" + ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + " Rare Drop! " + ChatColor.LIGHT_PURPLE + "" + ChatColor.MAGIC + "E");
                }
            }
        }



    }

    @EventHandler
    public void AbilityManager(PlayerInteractEvent event) {
        final HashMap<UUID, Long> cooldowns = new HashMap<>();

        Player player = event.getPlayer();
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 1000")) {
            long lastUsageTime = 0L;


            if (player.hasMetadata("excalipick_cooldown")) {
                lastUsageTime = player.getMetadata("excalipick_cooldown").get(0).asLong();
            }

            long currentTime = System.currentTimeMillis();
            long cooldownTime = 200000L;
            if (currentTime - lastUsageTime < cooldownTime) {
                player.sendMessage(ChatColor.RED + "Ability is on cooldown. Please wait " + (cooldownTime - (currentTime - lastUsageTime)) / 1000 + " seconds.");
                return;
            }

            PotionEffect hasteEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, 40 * 40, 2);
            player.addPotionEffect(hasteEffect);
            player.setMetadata("excalipick_cooldown", new FixedMetadataValue(plugin, currentTime));
        }
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && event.getPlayer().getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 2000")) {
            long lastUsageTimeEXPL = 0L;


            if (player.hasMetadata("excalipick_cooldownEXP")) {
                lastUsageTimeEXPL = player.getMetadata("excalipick_cooldownEXP").get(0).asLong();
            }

            long currentTime = System.currentTimeMillis();
            long cooldownTime = 50000L;
            if (currentTime - lastUsageTimeEXPL < cooldownTime) {
                player.sendMessage(ChatColor.RED + "Ability is on cooldown. Please wait " + (cooldownTime - (currentTime - lastUsageTimeEXPL)) / 1000 + " seconds.");
                return;
            }
            PotionEffect def = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 2 * 20, 999999);
            player.addPotionEffect(def);
            player.getWorld().createExplosion(player.getLocation(), 6.0F, false, true, null);
            player.setMetadata("excalipick_cooldownEXP", new FixedMetadataValue(plugin, currentTime));
        }

    }
}
