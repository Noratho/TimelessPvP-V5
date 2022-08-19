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

public class K02ScoutMethods {

    public static void shootPocketPistol(Player p) {

        Location spawnLoc = p.getEyeLocation();
        spawnLoc.setY(spawnLoc.getY() - 0.05);

        Arrow bullet = p.getWorld().spawnArrow(
                spawnLoc, p.getEyeLocation().getDirection(),
                1f, 0);

        PersistentDataContainer bulletNBT = bullet.getPersistentDataContainer();
        bulletNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING, "scout");


        bullet.setVelocity(p.getLocation().getDirection().multiply(1));
        bullet.setShooter(p);
        bullet.setPickupStatus(AbstractArrow.PickupStatus.DISALLOWED);

        // Give particle trail
        new BukkitRunnable() {
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

        // De-spawn after 8 seconds
        BukkitRunnable runnable = new BukkitRunnable() {
            public void run() {
                bullet.remove();
            }
        };
        runnable.runTaskLater(TimelessPvP5.getPlugin(), 8 * 20L);
    }


    public static void reloadPistol(Player p) {

        ItemStack healTokens = null;

        // get heal token amounts
        for (ItemStack items : p.getInventory().getContents()) {
            p.sendMessage(String.valueOf(items));
            if (items == null){ continue; }
            String name = ChatColor.stripColor(items.getItemMeta().getDisplayName());
            if (name.equals("Heal Token")) {
                healTokens = items;
                break;
            }
        }

        p.getInventory().clear();
        if (healTokens != null) {
            p.getInventory().addItem(healTokens);
        }
        ItemStack skull = K02ScoutData.getSkull();
        p.getInventory().setItem(EquipmentSlot.HEAD, skull);

        // Set up reload sequence
        ArrayList<Pair<Long, RunnableData>> rData = K02ScoutData.getReloadSequence();
        ReloadSequence sequence = new ReloadSequence(p, rData);
        sequence.generateSequence();
        sequence.runSequence();

        PlayerData pData = TimelessPvP5.getPlr(p.getUniqueId());
        pData.setActiveReload(sequence);
    }

}
