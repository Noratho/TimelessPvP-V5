package me.timelesspvp.timelesspvp5.dataClasses;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.LivingEntity;
import org.bukkit.persistence.PersistentDataContainer;
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
        buffCleanseHelper(key, buffs);
    }

    public BukkitTask getDebuff(String key) { return debuffs.get(key); }
    public void addDebuff(String key, BukkitTask debuff) {
        if (debuffs.containsKey(key)) {
            debuffs.get(key).cancel();
        }
        debuffs.put(key, debuff);
    }
    public void removeDebuff(String key) {
        buffCleanseHelper(key, debuffs);
    }

    private void buffCleanseHelper(String key, Map<String, BukkitTask> map) {
        if (map.containsKey(key)) {
            map.get(key).cancel();
            map.remove(key);

            LivingEntity entity = (LivingEntity) Bukkit.getEntity(uuid);
            if (Bukkit.getEntity(uuid) == null) {
                entity = Bukkit.getPlayer(uuid);
            }
            PersistentDataContainer pNBT = entity.getPersistentDataContainer();
            pNBT.remove(new NamespacedKey(TimelessPvP5.getPlugin(), key));
        }
    }
}
