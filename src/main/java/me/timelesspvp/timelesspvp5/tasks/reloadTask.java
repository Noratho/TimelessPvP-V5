package me.timelesspvp.timelesspvp5.tasks;

import me.timelesspvp.timelesspvp5.dataClasses.ItemWSlot;
import me.timelesspvp.timelesspvp5.dataClasses.RunnableData;
import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class reloadTask extends abstractTask{

    private RunnableData data;

    public reloadTask(Player p, Long delay, RunnableData data) {
        this.p = p;
        this.delay = delay;
        this.data = data;
    }

    @Override
    public void run() {
        for (SoundData sound : data.getSounds()) {
            p.playSound(p.getLocation(), sound.getSound(), sound.getVol(), sound.getPitch());
        }
        for (PotionEffect effect : data.getEffects()) {
            p.addPotionEffect(effect);
        }
        for (ItemWSlot item : data.getItems()) {
            if (item.getSlot() == -1) {
                p.getInventory().addItem(item.getItem());
            } else {
                p.getInventory().setItem(item.getSlot(), item.getItem());
            }

        }
    }
}
