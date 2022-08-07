package me.timelesspvp.timelesspvp5;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class playerData {

    public UUID getUuid() { return uuid; }

    public void setUuid(UUID uuid) { this.uuid = uuid; }

    public Inventory getInv() { return inv; }

    public void setInv(Inventory inv) { this.inv = inv; }

    public Location getLoc() { return loc; }
    public void setLoc(Location loc) { this.loc = loc; }

    public GameMode getGm() { return gm; }

    public void setGm(GameMode gm) { this.gm = gm; }

    public BukkitRunnable[] getActiveReloads() { return activeReloads; }

    public void setActiveReloads(BukkitRunnable[] activeReloads) { this.activeReloads = activeReloads; }

    public void cancelActiveReloads() {
        for (BukkitRunnable reload : this.activeReloads)
            reload.cancel();
    }

    private UUID uuid;
    private Inventory inv;
    private Location loc;
    private GameMode gm;
    private BukkitRunnable[] activeReloads;


    public playerData(UUID uuid, Inventory inv, Location loc, GameMode gm) {
        this.uuid = uuid;
        this.inv = inv;
        this.loc = loc;
        this.gm = gm;
    }
}
