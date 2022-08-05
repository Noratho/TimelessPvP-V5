package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
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

            PersistentDataContainer data = pro.getPersistentDataContainer();

            // If hit by scout pocket pistol bullet
            if (data.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "k02ScoutBullet"), PersistentDataType.INTEGER)) {

                // Cancel the damage
//                e.setCancelled(true);
                // Get the damage stored in th nbt
                int damage = data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutBullet"), PersistentDataType.INTEGER);
                // if entity is living give dmg
                if (ent instanceof LivingEntity) {
                    ((LivingEntity) ent).damage(damage, (Player) pro.getShooter());
                }

                e.setCancelled(true);
                pro.remove();
            }



        }


    }

}
