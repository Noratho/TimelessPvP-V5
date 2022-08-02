package me.timelesspvp.timelesspvp5;

import it.unimi.dsi.fastutil.Pair;
import me.timelesspvp.timelesspvp5.commands.leaveArena;
import me.timelesspvp.timelesspvp5.commands.openKitMenu;
import me.timelesspvp.timelesspvp5.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class TimelessPvP5 extends JavaPlugin {

    private static TimelessPvP5 plugin;
    private static Map<UUID, Pair<Inventory, Location>> invs = new HashMap<UUID, Pair<Inventory, Location>>();

    public static Map<UUID, Pair<Inventory, Location>> getInvs() {
        return invs;
    }

    public static void addEntryInvs(UUID uuid, Inventory inv, Location loc) {
        TimelessPvP5.invs.put(uuid, Pair.of(inv, loc));
    }

    public static void removeEntryInvs(UUID uuid) {
        TimelessPvP5.invs.remove(uuid);
    }

    @Override
    public void onEnable() {

        // Plugin startup logic
        Bukkit.getLogger().info("plugin start up. This gon be good");
        plugin = this;


        // Listeners
        getServer().getPluginManager().registerEvents(new rightClick(),this);
        getServer().getPluginManager().registerEvents(new menu(),this);
        getServer().getPluginManager().registerEvents(new projectileHit(),this);
        getServer().getPluginManager().registerEvents(new playerLeave(),this);
        getServer().getPluginManager().registerEvents(new playerKillPlayer(), this);

        // Commands
        getCommand("kits").setExecutor(new openKitMenu());
        getCommand("leave").setExecutor(new leaveArena());



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


