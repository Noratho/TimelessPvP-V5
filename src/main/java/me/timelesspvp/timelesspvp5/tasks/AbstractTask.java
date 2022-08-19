package me.timelesspvp.timelesspvp5.tasks;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class AbstractTask extends BukkitRunnable {

    protected Player p;
    protected Long delay;

    public Long getDelay() {
        return delay;
    }

    @Override
    public void run() {
    }
}
