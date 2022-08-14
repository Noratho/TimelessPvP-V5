package me.timelesspvp.timelesspvp5.tasks;

import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import org.bukkit.entity.Player;

public class soundTask extends abstractTask {

    private final SoundData sound;

    public soundTask(Player p, Long delay, SoundData sound) {
        this.p = p;
        this.delay = delay;
        this.sound = sound;
    }

    @Override
    public void run() {
        p.playSound(p.getLocation(), sound.getSound(), sound.getVol(), sound.getPitch());
    }

}
