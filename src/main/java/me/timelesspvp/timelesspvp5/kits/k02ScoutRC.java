package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class k02ScoutRC {

    public static void shootPocketPistol(Player p) {

        // damage calculated in half hearts
        int damage = 7;

        Arrow bullet = p.getWorld().spawnArrow(
                p.getEyeLocation(),
                p.getEyeLocation().getDirection(),
                4, 0);


        PersistentDataContainer data = bullet.getPersistentDataContainer();

        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutBullet"), PersistentDataType.INTEGER, damage);


    }
}
