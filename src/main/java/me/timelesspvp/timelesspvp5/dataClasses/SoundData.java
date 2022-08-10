package me.timelesspvp.timelesspvp5.dataClasses;

import org.bukkit.Sound;

public class SoundData {

    private final Sound sound;
    private final float vol;
    private final float pitch;

    public SoundData(Sound sound, float vol, float pitch) {
        this.sound = sound;
        this.vol = vol;
        this.pitch = pitch;
    }

    public Sound getSound() { return sound; }
    public float getVol() { return vol; }
    public float getPitch() { return pitch; }
}
