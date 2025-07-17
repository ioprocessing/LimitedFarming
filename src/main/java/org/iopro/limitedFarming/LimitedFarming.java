package org.iopro.limitedFarming;

import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class LimitedFarming extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Recipes.register();
        getServer().getPluginManager().registerEvents(new DirtListener(), this);
        getServer().getPluginManager().registerEvents(new WaterListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        HandlerList.unregisterAll(this);
        Bukkit.getScheduler().cancelTasks(this);
    }

    public static LimitedFarming getInstance() {
        return getPlugin(LimitedFarming.class);
    }
}
