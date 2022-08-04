package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.outsourceMethods;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;


public class playerLeave implements Listener {

    @EventHandler
    public void onPLayerLeave(PlayerQuitEvent e) {
        outsourceMethods.leaveProtocol(e.getPlayer());
    }
}
