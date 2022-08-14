package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import me.timelesspvp.timelesspvp5.kits.k07WeegeeMethods;
import me.timelesspvp.timelesspvp5.tasks.soundTask;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.javatuples.Pair;

public class playerShift implements Listener {

    static final String weegeeToken = "weegeeShift";
    static final Long weegeeCD = 2L;

    @EventHandler
    public void onShift(PlayerToggleSneakEvent e) {

        if (!e.isSneaking()) {
            return;
        }

        Player p = e.getPlayer();

        // if player not in game then end
        PersistentDataContainer perData = p.getPersistentDataContainer();
        if (perData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("out")) {
            return;
        }


        ItemStack item = p.getInventory().getItemInMainHand();

        switch (ChatColor.stripColor(item.getItemMeta().getDisplayName())) {
            case "Poltergust" -> {
                if (TimelessPvP5.cooldownEntryExists(p.getUniqueId(), weegeeToken)) {

                    if (TimelessPvP5.getCooldownEntry(
                            p.getUniqueId(), weegeeToken) > System.currentTimeMillis()) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 1 ,1);
                        return;
                    }
                }

                TimelessPvP5.addCooldownEntry(p.getUniqueId(), weegeeToken,
                        System.currentTimeMillis() + (weegeeCD * 1000));

                k07WeegeeMethods.weegeeShift(p);

            }
        }
    }
}
