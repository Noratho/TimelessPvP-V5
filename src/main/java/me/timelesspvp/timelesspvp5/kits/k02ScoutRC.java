package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class k02ScoutRC {

    public static void shootPocketPistol(Player p) {

        // damage calculated in half hearts
        int damage = 7;

        Location spawnLoc = p.getEyeLocation();

        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Arrow bullet = p.getWorld().spawnArrow(
                spawnLoc, p.getEyeLocation().getDirection(),
                (float) 0.6, 0);

        PersistentDataContainer data = bullet.getPersistentDataContainer();

        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutBullet"), PersistentDataType.INTEGER, damage);


        bullet.setVelocity(p.getLocation().getDirection().multiply(0.8) );
    }
}
