package me.timelesspvp.timelesspvp5;

import it.unimi.dsi.fastutil.Pair;
import me.timelesspvp.timelesspvp5.commands.leaveArena;
import me.timelesspvp.timelesspvp5.commands.lobbyCommand;
import me.timelesspvp.timelesspvp5.commands.openKitMenu;
import me.timelesspvp.timelesspvp5.commands.reloadConfig;
import me.timelesspvp.timelesspvp5.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;
import org.javatuples.Triplet;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class TimelessPvP5 extends JavaPlugin {

    private static TimelessPvP5 plugin;
    private static Map<UUID, Triplet<Inventory, Location, GameMode>> invs =
            new HashMap<UUID, Triplet<Inventory, Location, GameMode>>();

    public static Map<UUID, Triplet<Inventory, Location, GameMode>> getInvs() {
        return invs;
    }

    public static void addEntryInvs(UUID uuid, Inventory inv, Location loc, GameMode gm) {
        TimelessPvP5.invs.put(uuid, Triplet.with(inv, loc, gm));
    }

    public static void removeEntryInvs(UUID uuid) {
        TimelessPvP5.invs.remove(uuid);
    }

    @Override
    public void onEnable() {

        // Plugin startup logic
        Bukkit.getLogger().info("plugin start up. This gon be good");
        plugin = this;
        FileConfiguration config = this.getConfig();


        // Listeners
        getServer().getPluginManager().registerEvents(new rightClick(),this);
        getServer().getPluginManager().registerEvents(new menu(),this);
        getServer().getPluginManager().registerEvents(new projectileHit(),this);
        getServer().getPluginManager().registerEvents(new playerLeave(),this);
        getServer().getPluginManager().registerEvents(new playerKillPlayer(), this);
        getServer().getPluginManager().registerEvents(new playerRespawn(), this);
        getServer().getPluginManager().registerEvents(new playerLeave(), this);
        getServer().getPluginManager().registerEvents(new playerJoin(), this);

        // Commands
        getCommand("leave").setExecutor(new leaveArena());
        getCommand("reloadConfig").setExecutor(new reloadConfig());
        getCommand("lobby").setExecutor(new lobbyCommand());

        // Configs

            // Default
        config.options().copyDefaults(true);
        this.saveConfig();

    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("plugin shut down. kirbo");
    }

    public static TimelessPvP5 getPlugin() {
        return plugin;
    }
}


