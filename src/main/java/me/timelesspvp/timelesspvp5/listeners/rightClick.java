package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.kits.k02ScoutRC;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class rightClick implements Listener {

    @EventHandler
    public void useItem(PlayerInteractEvent e) {


        // If a right click
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ) {
            Player p = e.getPlayer();
            if (!e.hasItem()) {
                return;
            }
//        p.sendMessage(ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName()));

            switch (ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName())) {

                case "zzzPretty Boy's Pocket Pistolzzz":
                    k02ScoutRC.shootPocketPistol(p);
//                p.sendMessage("pew");
                    e.getItem().setAmount(e.getItem().getAmount() - 1);

                case "Reload":

            }
        }

    }
}
