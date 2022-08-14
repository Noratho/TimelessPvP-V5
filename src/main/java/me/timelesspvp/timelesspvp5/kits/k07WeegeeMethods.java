package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import me.timelesspvp.timelesspvp5.tasks.soundTask;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class k07WeegeeMethods {

    public static void weegeeShift(Player p) {
        p.setVelocity(p.getFacing().getDirection().multiply(-1.7).add(new Vector(0,0.2, 0)));
        p.playSound(p.getLocation(), Sound.ENTITY_CAT_AMBIENT, 15, 0.5f);

        // Task to notify when cooldown finished
        SoundData notifySound = new SoundData(Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        soundTask notifyCooldown = new soundTask(p, 50L, notifySound);
        notifyCooldown.runTaskLater(TimelessPvP5.getPlugin(), notifyCooldown.getDelay());
    }

    public static void useOneUp(Player p) {
        p.setHealth(20);
    }
}
