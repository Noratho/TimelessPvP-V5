package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.LivingEntityData;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Egg;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Time;
import java.util.UUID;

public class k03MelonMethods {

    public static void shootEgg(Player p) {
        Location spawnLoc = p.getEyeLocation();
        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Egg egg = p.getWorld().spawn(spawnLoc, Egg.class);
//        egg.setVisualFire(true);
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

    public static BukkitRunnable getMarkTask(LivingEntity victim, int hits) {
        PersistentDataContainer victimNBT = victim.getPersistentDataContainer();

        return new BukkitRunnable() {
            int timer = 3;
            final ItemStack melon = new ItemStack(Material.MELON_SLICE);
            UUID victimUUID = victim.getUniqueId();

            @Override
            public void run() {
                if (timer != 0) {
                    // extra is speed in this case
                    double offset = 0.01 + hits*0.01;
                    victim.getWorld().spawnParticle(Particle.ITEM_CRACK,
                            victim.getLocation().add(0, 2.2, 0),hits*10,
                            offset, offset, offset, 0.05, melon);
                    timer--;
                } else {
                    cancel();
                    if (TimelessPvP5.getLiveEntData().containsKey(victimUUID)) {
                        if (!TimelessPvP5.getEnt(victimUUID).isActive()) {
                            TimelessPvP5.getLiveEntData().remove(victimUUID);
                        }
                    }
                    victimNBT.remove(new NamespacedKey(TimelessPvP5.getPlugin(),
                            "melonMark"));
                }
            }
        };
    }


}
