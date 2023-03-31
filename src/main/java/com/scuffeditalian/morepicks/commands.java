package com.scuffeditalian.morepicks;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (command.getName().equals("GiveAllPicks")) {
            player.getInventory().addItem(itemstacks.ExcalipickItem);
            player.getInventory().addItem(itemstacks.EscaliPickItem2);

        }
        if(command.getName().equals("GiveAllDusts")) {
            player.getInventory().addItem(itemstacks.ExcaliDust);
            player.getInventory().addItem(itemstacks.MithoDust);
            player.getInventory().addItem(itemstacks.TerraDust);
        }
        return false;
    }
}
