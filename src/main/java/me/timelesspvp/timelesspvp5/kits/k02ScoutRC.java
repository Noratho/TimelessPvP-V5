package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class k02ScoutRC {

    public static void shootPocketPistol(Player p) {

        // damage calculated in half hearts
        int damage = 7;

        Location spawnLoc = p.getEyeLocation();

        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Arrow bullet = p.getWorld().spawnArrow(
                spawnLoc, p.getEyeLocation().getDirection(),
                1f, 0);

        PersistentDataContainer data = bullet.getPersistentDataContainer();

        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutBullet"), PersistentDataType.INTEGER, damage);


        bullet.setVelocity(p.getLocation().getDirection().multiply(1));
        bullet.setShooter(p);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (!bullet.isDead()) {
                    Particle.DustOptions options =
                            new Particle.DustOptions(Color.fromRGB(255,255,0), 0.5f);
                    bullet.getWorld().spawnParticle(Particle.REDSTONE,
                            bullet.getLocation(), 1, options);
                } else {
                    cancel();
                }

            }
        }.runTaskTimer(TimelessPvP5.getPlugin(), 0L, 1L);
    }
}
