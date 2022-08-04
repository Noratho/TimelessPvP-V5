package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import me.timelesspvp.timelesspvp5.outsourceMethods;

public class playerRespawn implements Listener {

    @EventHandler
    public static void onRespawn(PlayerRespawnEvent e) {

        Player p = e.getPlayer();
        PersistentDataContainer data = p.getPersistentDataContainer();

        // if player if player is in lobby state or in state then run protocol
        if (!data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("out")) {

            outsourceMethods.lobbyProtocol(p);
        }
    }
}
