package me.timelesspvp.timelesspvp5.dataClasses;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class LivingEntityData {

    private UUID uuid;
    private Map<String, BukkitTask> buffs = new HashMap<String, BukkitTask>();
    private Map<String, BukkitTask> debuffs = new HashMap<String, BukkitTask>();


    public LivingEntityData(UUID uuid) {
        this.uuid = uuid;
    }

    public boolean isActive() {

        BukkitScheduler scheduler = Bukkit.getScheduler();
        for (BukkitTask task : buffs.values()) {
            if (scheduler.isCurrentlyRunning(task.getTaskId())) { return true; }
        }
        for (BukkitTask task : debuffs.values()) {
            if (scheduler.isCurrentlyRunning(task.getTaskId())) { return true; }
        }
        return false;
    }

    public UUID getUuid() { return uuid; }
    public void setUuid(UUID uuid) { this.uuid = uuid; }

    public BukkitTask getBuff(String key) { return buffs.get(key); }
    public void addBuff(String key, BukkitTask buff) {
        if (buffs.containsKey(key)) {
            buffs.get(key).cancel();
        }
        buffs.put(key, buff);
    }
    public void removeBuff(String key) {
        if (buffs.containsKey(key)) {
            buffs.get(key).cancel();
            buffs.remove(key);
            Player p = Bukkit.getPlayer(uuid);
            PersistentDataContainer pNBT = p.getPersistentDataContainer();
            pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                    key), PersistentDataType.BYTE, (byte) 0);
        }
    }


    public BukkitTask getDebuff(String key) { return debuffs.get(key); }
    public void addDebuff(String key, BukkitTask debuff) {
        if (debuffs.containsKey(key)) {
            debuffs.get(key).cancel();
        }
        debuffs.put(key, debuff);
    }
    public void removeDebuff(String key) {
        if (debuffs.containsKey(key)) {
            debuffs.get(key).cancel();
            debuffs.remove(key);
            Player p = Bukkit.getPlayer(uuid);
            PersistentDataContainer pNBT = p.getPersistentDataContainer();
            pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                    key), PersistentDataType.BYTE, (byte) 0);
        }
    }
}
