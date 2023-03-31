package com.scuffeditalian.morepicks;

import org.bukkit.plugin.java.JavaPlugin;
import com.scuffeditalian.morepicks.itemstacks.*;
public final class Morepicks extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        itemstacks.ItemInit();
        getCommand("givePick1").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new events(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
