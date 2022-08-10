package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class itemDrop implements Listener {

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {

        Player p = e.getPlayer();
        PersistentDataContainer perData = p.getPersistentDataContainer();
        if (!perData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("in")) {
            e.setCancelled(true);
        }

    }

}
