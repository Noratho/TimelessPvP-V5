package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class entityHit implements Listener {

    @EventHandler
    public static void checkSweepEdge(EntityDamageByEntityEvent e) {

        if (e.getDamager() instanceof Player) {
            Player p = (Player) e.getDamager();
            PersistentDataContainer data = p.getPersistentDataContainer();

            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {

                if (data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "state"), PersistentDataType.STRING).equals("in")) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
