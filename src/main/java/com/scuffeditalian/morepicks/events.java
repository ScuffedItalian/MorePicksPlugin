package com.scuffeditalian.morepicks;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import java.util.Random;

import java.util.EventListener;

public class events implements Listener {

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
}
