package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class playerJoin implements Listener {

    @EventHandler
    public static void onJoin(PlayerJoinEvent e) {

        Player p = e.getPlayer();

        PersistentDataContainer data = p.getPersistentDataContainer();
        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING, "out");
    }
}
