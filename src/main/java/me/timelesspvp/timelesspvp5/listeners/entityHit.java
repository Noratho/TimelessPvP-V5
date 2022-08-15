package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.ChatColor;
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
    public static void onHit(EntityDamageByEntityEvent e) {

        // if damage is done by player
        if (e.getDamager() instanceof Player) {
            Player attacker = (Player) e.getDamager();
            PersistentDataContainer attackerNBT = attacker.getPersistentDataContainer();

            // Cancel sweep damage
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {

                if (attackerNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "state"), PersistentDataType.STRING).equals("in")) {
                    e.setCancelled(true);
                }
            }

            switch (ChatColor.stripColor(
                    attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName())) {

                case "Derp_Airlines" -> {

                }

            }


        }
    }
}
