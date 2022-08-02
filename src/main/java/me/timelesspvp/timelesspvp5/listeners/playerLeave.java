package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.leaveExecute;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class playerLeave implements Listener {

    @EventHandler
    public void onPLayerLeave(PlayerQuitEvent e) {

        Bukkit.getLogger().info("playerLeft");
        leaveExecute.leaveArena(e.getPlayer());
    }
}
