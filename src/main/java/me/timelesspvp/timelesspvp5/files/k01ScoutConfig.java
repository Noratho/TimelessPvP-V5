package me.timelesspvp.timelesspvp5.files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class k01ScoutConfig {

    private static File file;
    private static FileConfiguration scoutConfig;

    // Set up the config
    public static void setup() {
        file = new File(Bukkit.getServer()
                .getPluginManager()
                .getPlugin("TimelessPvP5")
                .getDataFolder(), "scoutConfig.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Unable to create scout config");
            }
        }

        // Load config file data into object
        scoutConfig = YamlConfiguration.loadConfiguration(file);
    }

    // Get the file configuration so you can edit it
    public static FileConfiguration get() {
        return scoutConfig;
    }

    // Save scout config
    public static void save() {
        try {
            scoutConfig.save(file);
        } catch (IOException e) {
            System.out.println("Unable to save scout config");
        }
    }

    // Reload the config data in the plugin without having to restart server
    public static void reload() {
        scoutConfig = YamlConfiguration.loadConfiguration(file);
    }

}
