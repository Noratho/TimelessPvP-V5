package me.timelesspvp.timelesspvp5;

import me.timelesspvp.timelesspvp5.commands.leaveArena;
import me.timelesspvp.timelesspvp5.commands.lobbyCommand;
import me.timelesspvp.timelesspvp5.commands.reloadConfig;
import me.timelesspvp.timelesspvp5.dataClasses.LivingEntityData;
import me.timelesspvp.timelesspvp5.dataClasses.PlayerData;
import me.timelesspvp.timelesspvp5.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.javatuples.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class TimelessPvP5 extends JavaPlugin {

    private static TimelessPvP5 plugin;
    private static Map<UUID, PlayerData> plrData = new HashMap<UUID, PlayerData>();
    private static Map<UUID, LivingEntityData> liveEntData = new HashMap<UUID, LivingEntityData>();
    private static Map<Pair<UUID, String>, Long> cooldowns = new HashMap<>();


    // PlayerData manger methods
    public static Map<UUID, PlayerData> getPlrData() {
        return plrData;
    }
    public static PlayerData getPlr(UUID uuid) { return plrData.get(uuid); }
    public static void addPlrDataEntry(UUID uuid, Inventory inv, Location loc, GameMode gm) {
        PlayerData data = new PlayerData(uuid, inv, loc, gm);
        TimelessPvP5.plrData.put(uuid, data);
    }
    public static void removePlrDataEntry(UUID uuid) {
        TimelessPvP5.plrData.remove(uuid);
    }


    // LivingEntityData manger methods
    public static Map<UUID, LivingEntityData> getLiveEntData() {
        return liveEntData;
    }
    public static LivingEntityData getEnt(UUID uuid) { return liveEntData.get(uuid); }
    public static void addLiveEntDataEntry(UUID uuid) {
        LivingEntityData data = new LivingEntityData(uuid);
        TimelessPvP5.liveEntData.put(uuid, data);
    }
    public static void removeLiveEntDataEntry(UUID uuid) {
        TimelessPvP5.liveEntData.remove(uuid);
    }


    // Cooldown manger methods
    public static Long getCooldownEntry(UUID uuid, String CDName) {
        return cooldowns.get(new Pair<>(uuid, CDName));
    }
    public static void addCooldownEntry(UUID uuid, String CDName, Long cooldown) {
        cooldowns.put(new Pair<>(uuid, CDName), cooldown);
    }
    public static boolean cooldownEntryExists(UUID uuid, String CDName) {
        return cooldowns.containsKey(new Pair<>(uuid, CDName));
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
        getServer().getPluginManager().registerEvents(new playerLeaveOrJoin(),this);
        getServer().getPluginManager().registerEvents(new playerKillPlayer(), this);
        getServer().getPluginManager().registerEvents(new playerRespawn(), this);
        getServer().getPluginManager().registerEvents(new playerLeaveOrJoin(), this);
        getServer().getPluginManager().registerEvents(new healthRegen(), this);
        getServer().getPluginManager().registerEvents(new entityHit(), this);
        getServer().getPluginManager().registerEvents(new itemDrop(), this);
        getServer().getPluginManager().registerEvents(new playerShift(), this);

        // Commands
        getCommand("leave").setExecutor(new leaveArena());
        getCommand("reloadConfig").setExecutor(new reloadConfig());
        getCommand("lobby").setExecutor(new lobbyCommand());


        // Configs

            // Default
        config.options().copyDefaults(true);
        this.saveConfig();

        addOldHealthRegen();
    }


    @Override
    public void onDisable() {
        Bukkit.getLogger().info("plugin shut down. kirbo");
    }

    public static TimelessPvP5 getPlugin() {
        return plugin;
    }


    // returns old slower health regen for players in the game
    // should probably move somewhere but will do later
    public final void addOldHealthRegen() {
        BukkitTask addRegen = new BukkitRunnable() {
            @Override
            public void run() {
                for (final Player p : new ArrayList<>(getServer().getOnlinePlayers())) {
                    PersistentDataContainer data = p.getPersistentDataContainer();

                    if (data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                            "state"), PersistentDataType.STRING).equals("in")) {
                        final int health = (int) p.getHealth();
                        if (health > 0 && health < 20) {
                            p.setHealth(health + 1);
                        }
                    }
                }
            }
        }.runTaskTimer(this, 0L, 80L);
    }
}


