package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.k02ScoutData;
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

import java.util.Objects;

public class projectileHit implements Listener {

    private final int scoutDmg = 7;
    private final int pirateDmg = 12;

    @EventHandler
    public void projectileHits(ProjectileHitEvent e) {

        Projectile proj = e.getEntity();

        if (e.getHitEntity() == null) { return; }
        if (!(proj.getShooter() instanceof Player)){ return; }

        Player shooter = (Player) proj.getShooter();
        Entity victim = e.getHitEntity();
        PersistentDataContainer shooterNBT = shooter.getPersistentDataContainer();
        PersistentDataContainer victimNBT = victim.getPersistentDataContainer();
        PersistentDataContainer projNBT = proj.getPersistentDataContainer();

        if (!(victim instanceof LivingEntity)) { return; }
        // check if its a projectile shot by a kit
        if (!projNBT.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING)) { return; }


        String kit = projNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING);

        boolean haveMatched = true;
        switch (Objects.requireNonNull(kit)) {
            case "scout" -> {
                ((LivingEntity) victim).damage(scoutDmg, shooter);
                scoutStacks(shooter, shooterNBT);
            }
            case "melon" -> {
                // mark enemy hit
                victimNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "melonMarked"), PersistentDataType.BYTE, (byte) 1);
            }
            case "pirate" -> {
                ((LivingEntity) victim).damage(pirateDmg, shooter);
            }
            default -> {
                haveMatched = false;
            }
        }
        if (haveMatched) {
            e.setCancelled(true);
            proj.remove();
        }
    }


    public void scoutStacks(Player p, PersistentDataContainer perData) {
        int stacks = perData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutStacks"), PersistentDataType.INTEGER) + 1;

        // Scout combo hits
        switch (stacks) {

            case 1 -> {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.529732f);
                perData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
            }
            case 2 -> {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.561231f);
                perData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
            }
            case 3 -> {
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 0.594604f);
                perData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutStacks"), PersistentDataType.INTEGER, stacks);
            }
            case 4 -> {
                perData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "k02ScoutStacks"), PersistentDataType.INTEGER, 0);
                p.getInventory().addItem(k02ScoutData.getPocketPistol(1));
                p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 0.5f, 0.707107f);
            }
        }
    }
}
