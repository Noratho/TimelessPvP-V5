package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.k02Scout;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class projectileHit implements Listener {

    @EventHandler
    public void projectileHits(ProjectileHitEvent e) {

        Projectile pro = e.getEntity();

        if (e.getHitEntity() != null) {
            Entity ent = e.getHitEntity();

            PersistentDataContainer proData = pro.getPersistentDataContainer();

            // If hit by scout pocket pistol bullet
            if (proData.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "k02ScoutBullet"), PersistentDataType.INTEGER)) {

                Player p = (Player) pro.getShooter();
                PersistentDataContainer pData = p.getPersistentDataContainer();

                // Get the damage stored in the nbt
                int damage = proData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutBullet"), PersistentDataType.INTEGER);
                // if entity is living give dmg
                if (ent instanceof LivingEntity) {
                    ((LivingEntity) ent).damage(damage, p);

                    int stacks = pData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                            "k02ScoutStacks"), PersistentDataType.INTEGER) + 1;

                    switch (stacks) {

                        case 1 -> {
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.529732f);
                            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                                    "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
                        }
                        case 2 -> {
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.561231f);
                            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                                    "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
                        }
                        case 3 -> {
                            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.594604f);
                            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                                    "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
                        }
                        case 4 -> {
                            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                                    "k02ScoutStacks"), PersistentDataType.INTEGER, 0);
                            p.getInventory().addItem(k02Scout.getPocketPistol(1));
                            p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 0.5f, 0.707107f);
                        }
                    }
                }

                e.setCancelled(true);
                pro.remove();



            }



        }


    }

}
