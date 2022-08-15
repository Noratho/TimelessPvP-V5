package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

public class k03MelonMethods {

    public static void shootEgg(Player p) {
        Location spawnLoc = p.getEyeLocation();
        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Egg egg = p.getWorld().spawn(spawnLoc, Egg.class);
        egg.setVisualFire(true);
        egg.setCustomName("Egg :D");
        egg.setVelocity(p.getLocation().getDirection().multiply(1.2));
        egg.setShooter(p);

        PersistentDataContainer eggNBT = egg.getPersistentDataContainer();
        eggNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING, "melon");


        // De-spawn after 5 seconds
        BukkitRunnable runnable = new BukkitRunnable() {
            public void run() {
                egg.remove();
            }
        };
        runnable.runTaskLater(TimelessPvP5.getPlugin(), 5 * 20L);
    }


}
