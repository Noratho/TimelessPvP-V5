package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.kits.k02ScoutRC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class rightClick implements Listener {

    @EventHandler
    public void useItem(PlayerInteractEvent e) {

        Player p = e.getPlayer();
        if (!e.hasItem()) {
            return;
        }

        switch (ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName())) {

            case "Pretty Boy's Pocket Pistol":
                k02ScoutRC.shootPocketPistol(p);

            case "Reload":

        }

    }
}
