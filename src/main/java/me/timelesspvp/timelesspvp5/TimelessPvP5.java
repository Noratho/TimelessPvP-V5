package me.timelesspvp.timelesspvp5;

import me.timelesspvp.timelesspvp5.commands.giveKitGuiCommand;
import me.timelesspvp.timelesspvp5.listeners.ClassRightClick;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class TimelessPvP5 extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("plugin start up. This gon be good");
        getServer().getPluginManager().registerEvents(new ClassRightClick(),this);


        // Commands
        getCommand("kits").setExecutor(new giveKitGuiCommand());
    }


    @Override
    public void onDisable() {
        System.out.println("plugin shut down. kirbo");
    }
}
