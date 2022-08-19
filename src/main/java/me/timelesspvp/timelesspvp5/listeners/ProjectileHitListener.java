package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.LivingEntityData;
import me.timelesspvp.timelesspvp5.kits.K02ScoutData;
import me.timelesspvp.timelesspvp5.kits.K03MelonMethods;
import org.bukkit.*;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitTask;

import java.util.Objects;

public class ProjectileHitListener implements Listener {

    private final int scoutDmg = 7;
    private final int pirateDmg = 12;

    @EventHandler
    public void projectileHits(ProjectileHitEvent e) {

        Projectile proj = e.getEntity();
        PersistentDataContainer projNBT = proj.getPersistentDataContainer();

        if (e.getHitEntity() == null) { return; }
        if (!(proj.getShooter() instanceof Player)){ return; }
        if (!(e.getHitEntity() instanceof LivingEntity)) { return; }
        // check if its a projectile shot by a kit
        if (!projNBT.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING)) { return; }

        Player shooter = (Player) proj.getShooter();
        LivingEntity victim = (LivingEntity) e.getHitEntity();
        PersistentDataContainer shooterNBT = shooter.getPersistentDataContainer();
        PersistentDataContainer victimNBT = victim.getPersistentDataContainer();


        String kit = projNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "projKitOrig"), PersistentDataType.STRING);

        boolean haveMatched = true;
        switch (Objects.requireNonNull(kit)) {
            case "scout" -> {
                victim.damage(scoutDmg, shooter);
                updateScoutStacks(shooter, shooterNBT);
            }

            case "melon" -> {
                // mark enemy hit
                int stacks = 1;
                if (victimNBT.has(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "melonMark"))) {
                    stacks = (int) victimNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                                    "melonMark"), PersistentDataType.BYTE) + 1;
                }
                victimNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "melonMark"), PersistentDataType.BYTE, (byte) stacks);

                // Give particle mark
                BukkitTask debuff = K03MelonMethods.getMarkTask(victim, stacks)
                        .runTaskTimer(TimelessPvP5.getPlugin(), 0L, 20L);

                // if player add buff to player
                if (victim instanceof Player) {
                    TimelessPvP5.getPlr(victim.getUniqueId()).addDebuff("melonMark",debuff);
                } else {
                    if (!TimelessPvP5.getLiveEntData().containsKey(victim.getUniqueId())) {
                        TimelessPvP5.addLiveEntDataEntry(victim.getUniqueId());
                    }
                    LivingEntityData entData = TimelessPvP5.getEnt(victim.getUniqueId());
                    entData.addDebuff("melonMark", debuff);
                }
            }

            case "pirate" -> {
                victim.damage(pirateDmg, shooter);
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


    public void updateScoutStacks(Player p, PersistentDataContainer perData) {
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
                p.getInventory().addItem(K02ScoutData.getPocketPistol(1));
                p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 0.5f, 0.707107f);
            }
        }
    }
}
