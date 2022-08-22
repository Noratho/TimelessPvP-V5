package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import me.timelesspvp.timelesspvp5.outsourceMethods.OutsourceMethods;

public class PlayerRespawnListener implements Listener {

    @EventHandler
    public static void onRespawn(PlayerRespawnEvent e) {

        Player p = e.getPlayer();
        PersistentDataContainer pNBT = p.getPersistentDataContainer();

        // if player if player is in lobby state or in state then run protocol
        if (!pNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("out")) {

            OutsourceMethods.lobbyProtocol(p);
        }
    }
}
