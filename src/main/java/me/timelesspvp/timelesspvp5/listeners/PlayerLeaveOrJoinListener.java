package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.outsourceMethods;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;


public class PlayerLeaveOrJoinListener implements Listener {


    // Player DC
    @EventHandler
    public void onPLayerLeave(PlayerQuitEvent e) {
        outsourceMethods.leaveProtocol(e.getPlayer());
    }

    // Player Connect
    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        PersistentDataContainer pNBT = p.getPersistentDataContainer();
        pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING, "out");
    }
}
