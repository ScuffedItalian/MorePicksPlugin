package com.scuffeditalian.morepicks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;
import java.util.Random;

import java.util.EventListener;
import java.util.UUID;

public class events implements Listener {
    Morepicks plugin = Morepicks.getInstance();
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
        if(event.getAction() == Action.RIGHT_CLICK_BLOCK && player.getItemInHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "Excalipick 1000")) {
            long lastUsageTime = 0L;


            if (player.hasMetadata("excalipick_cooldown")) {
                lastUsageTime = player.getMetadata("excalipick_cooldown").get(0).asLong();
            }

            long currentTime = System.currentTimeMillis();
            long cooldownTime = 200000L; // Set cooldown time to 5 seconds
            if (currentTime - lastUsageTime < cooldownTime) {
                player.sendMessage(ChatColor.RED + "Ability is on cooldown. Please wait " + (cooldownTime - (currentTime - lastUsageTime)) / 1000 + " seconds.");
                return;
            }

            PotionEffect hasteEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, 40 * 40, 2);
            player.addPotionEffect(hasteEffect);
            player.setMetadata("excalipick_cooldown", new FixedMetadataValue(plugin, currentTime));
        }

    }
}
