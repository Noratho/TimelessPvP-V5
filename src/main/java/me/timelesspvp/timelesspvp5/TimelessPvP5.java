package me.timelesspvp.timelesspvp5;

import me.timelesspvp.timelesspvp5.commands.openKitMenu;
import me.timelesspvp.timelesspvp5.listeners.rightClick;
import me.timelesspvp.timelesspvp5.listeners.menu;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class TimelessPvP5 extends JavaPlugin {

    private static TimelessPvP5 plugin;

    @Override
    public void onEnable() {

        // Plugin startup logic
        Bukkit.getLogger().info("plugin start up. This gon be good");
        plugin = this;


        // Listeners
        getServer().getPluginManager().registerEvents(new rightClick(),this);
        getServer().getPluginManager().registerEvents(new menu(),this);
        getServer().getPluginManager().registerEvents(new projectileHit(),this);

        // Commands
        getCommand("kits").setExecutor(new openKitMenu());



        // Configs

        // Default
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // archer
        getConfig().addDefault("spawns.archer.x", 0);
        getConfig().addDefault("spawns.archer.y", 0);
        getConfig().addDefault("spawns.archer.z", 0);
        getConfig().addDefault("spawns.archer.yaw", 0); // left right
        getConfig().addDefault("spawns.archer.pitch", 0); //up down

        // scout
        getConfig().addDefault("spawns.scout.x", 0);
        getConfig().addDefault("spawns.scout.y", 0);
        getConfig().addDefault("spawns.scout.z", 0);
        getConfig().addDefault("spawns.scout.yaw", 0); // left right
        getConfig().addDefault("spawns.scout.pitch", 0); //up down

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("plugin shut down. kirbo");
    }

    public static TimelessPvP5 getPlugin() {
        return plugin;
    }
}


