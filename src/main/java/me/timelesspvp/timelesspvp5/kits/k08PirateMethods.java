package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.PlayerData;
import me.timelesspvp.timelesspvp5.dataClasses.RunnableData;
import me.timelesspvp.timelesspvp5.sequences.ReloadSequence;
import org.bukkit.*;
import org.bukkit.entity.AbstractArrow;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitRunnable;
import org.javatuples.Pair;

import java.util.ArrayList;

public class k08PirateMethods {

    public static void shootMusket(Player p) {

        Location spawnLoc = p.getEyeLocation();
        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Arrow musketBall = p.getWorld().spawnArrow(
                spawnLoc, p.getEyeLocation().getDirection(),
                1f, 0);

        PersistentDataContainer data = musketBall.getPersistentDataContainer();
        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING, "pirate");

        musketBall.setVelocity(p.getLocation().getDirection().multiply(3));
        musketBall.setShooter(p);
        musketBall.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);
//        p.spawnParticle();
        p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 1, 1);

        // De-spawn after 8 seconds
        BukkitRunnable runnable = new BukkitRunnable() {
            public void run() {
                musketBall.remove();
            }
        };
        runnable.runTaskLater(TimelessPvP5.getPlugin(), 8 * 20L);

    }


    public static void reloadPistol(Player p) {
        p.getInventory().clear();
        ItemStack skull = k02ScoutData.getSkull();
        p.getInventory().setItem(EquipmentSlot.HEAD, skull);

        // Set up reload sequence
        ArrayList<Pair<Long, RunnableData>> rData = k02ScoutData.getScoutReloadSequence();
        ReloadSequence sequence = new ReloadSequence(p, rData);
        sequence.generateSequence();
        sequence.runSequence();

        PlayerData pData = TimelessPvP5.getPlrData().get(p.getUniqueId());
        pData.setActiveReload(sequence);
    }
}
