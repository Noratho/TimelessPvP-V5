package me.timelesspvp.timelesspvp5.dataClasses;

import me.timelesspvp.timelesspvp5.sequences.ReloadSequence;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.inventory.Inventory;

import java.util.UUID;

public class PlayerData extends LivingEntityData {

    // Stored data
    private Inventory inv;
    private Location loc;
    private GameMode gm;

    private ReloadSequence activeReload;


    public PlayerData(UUID uuid, Inventory inv, Location loc, GameMode gm) {
        super(uuid);
        this.inv = inv;
        this.loc = loc;
        this.gm = gm;
    }

    public Inventory getInv() { return inv; }
    public void setInv(Inventory inv) { this.inv = inv; }

    public Location getLoc() { return loc; }
    public void setLoc(Location loc) { this.loc = loc; }

    public GameMode getGm() { return gm; }
    public void setGm(GameMode gm) { this.gm = gm; }

    public ReloadSequence getActiveReloads() { return activeReload; }
    public void setActiveReload(ReloadSequence newReload) { this.activeReload = newReload; }

    public void cancelActiveReloads() {
        this.activeReload.cancel();
        this.activeReload = null;
    }
}
