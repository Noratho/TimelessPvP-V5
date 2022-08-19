package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class HealthRegenListener implements Listener {

    @EventHandler
    public static void onRegen(EntityRegainHealthEvent e) {

        if(e.getEntity() instanceof Player) {

            Player p = (Player) e.getEntity();
            PersistentDataContainer data = p.getPersistentDataContainer();

            if (data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING).equals("in")) {
                e.setCancelled(true);
            }
        }
    }
}
