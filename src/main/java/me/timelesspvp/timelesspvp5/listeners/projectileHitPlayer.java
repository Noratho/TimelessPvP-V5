package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class projectileHitPlayer implements Listener {

    @EventHandler
    public void projectileHits(ProjectileHitEvent e) {

        Projectile pro = e.getEntity();

        if (e.getHitEntity() != null) {
            Entity ent = e.getHitEntity();

            PersistentDataContainer data = pro.getPersistentDataContainer();

            if (data.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "k02ScoutBullet"), PersistentDataType.INTEGER)) {

                e.setCancelled(true);
                int damage = data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutBullet"), PersistentDataType.INTEGER);

                if (ent instanceof LivingEntity) {
                    ((LivingEntity) ent).damage(damage);
                }

            }


        }


    }

}
