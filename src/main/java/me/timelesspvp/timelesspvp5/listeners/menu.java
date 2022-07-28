package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.kits.k02Scout;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class menu implements Listener {

    @EventHandler
    public void onKitSelect(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (ChatColor.stripColor(e.getView().getTitle()) .equalsIgnoreCase("Choose your kit")) {
            if (e.getCurrentItem() == null) {
                return;
            }

            // On kit selection
            switch (e.getCurrentItem().getType()) {
                // scout
                case BLACK_STAINED_GLASS -> {
                    p.sendMessage("scout");
                    Bukkit.getLogger().info("Scout Choose");
                    p.closeInventory();
                    k02Scout.giveKit(p);
                }
                // Archer
                case ARROW -> {
                    p.closeInventory();
                }
            }

            Bukkit.getLogger().info(String.valueOf(e.getRawSlot()));

            if (e.getRawSlot() < 27) {
                e.setCancelled(true);
            }

        }


        // Cancels the event but actually means you can't move it
    }

}
