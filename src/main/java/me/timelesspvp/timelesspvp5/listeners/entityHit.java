package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.LivingEntityData;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;

public class entityHit implements Listener {

    @EventHandler
    public static void onHit(EntityDamageByEntityEvent e) {

        // if damage is done by player
        if (e.getDamager() instanceof Player) {
            Player attacker = (Player) e.getDamager();
            PersistentDataContainer attackerNBT = attacker.getPersistentDataContainer();
            if (!(e.getEntity() instanceof LivingEntity)) { return; }
            LivingEntity victim = (LivingEntity) e.getEntity();
            PersistentDataContainer victimNBT = victim.getPersistentDataContainer();

            // Cancel sweep damage
            if (e.getCause() == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {

                if (attackerNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "state"), PersistentDataType.STRING).equals("in")) {
                    e.setCancelled(true);
                }
            }

            boolean haveMatched = true;
            switch (ChatColor.stripColor(
                    attacker.getInventory().getItemInMainHand().getItemMeta().getDisplayName())) {

                case "Derp_Airlines" -> {
                    if (victimNBT.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                            "melonMark"))) {
                        int stacks = (int) victimNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                                "melonMark"), PersistentDataType.BYTE);

                        double yAdd = stacks/(1.7*Math.sqrt(stacks));
                        victim.setVelocity(victim.getVelocity()
                                .add(new Vector(0, yAdd, 0)));

                        Bukkit.getLogger().info("derp bong");
                        TimelessPvP5.getEnt(victim.getUniqueId()).removeDebuff("melonMark");
                        e.setCancelled(true);
                    }
                }
                default -> {
                    haveMatched = false;
                }
            }


        }
    }
}
