package me.timelesspvp.timelesspvp5;

import me.timelesspvp.timelesspvp5.commands.openKitMenu;
import me.timelesspvp.timelesspvp5.listeners.classRightClick;
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
        getServer().getPluginManager().registerEvents(new classRightClick(),this);
        getServer().getPluginManager().registerEvents(new menu(),this);

        // Commands
        getCommand("kits").setExecutor(new openKitMenu());



        // Configs

        // Default
        getConfig().options().copyDefaults();
        saveDefaultConfig();

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("plugin shut down. kirbo");
    }

    public static TimelessPvP5 getPlugin() {
        return plugin;
    }
}


