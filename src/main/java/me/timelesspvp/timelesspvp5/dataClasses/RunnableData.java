package me.timelesspvp.timelesspvp5.dataClasses;

import org.bukkit.potion.PotionEffect;

// Data class that stores what sounds, effects and items are given at a specific point in a task sequence
public class RunnableData {

    private SoundData[] sounds;
    private PotionEffect[] effects;
    // Slot and items
    private ItemWSlot[] items;

    public RunnableData(SoundData[] sounds,
                        PotionEffect[] effects,
                        ItemWSlot[] items) {

        this.sounds = sounds;
        this.effects = effects;
        this.items = items;
    }

    public SoundData[] getSounds() { return sounds; }
    public PotionEffect[] getEffects() { return effects; }
    public ItemWSlot[] getItems() { return items; }

}