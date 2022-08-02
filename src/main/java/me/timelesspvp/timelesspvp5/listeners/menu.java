package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.k01Archer;
import me.timelesspvp.timelesspvp5.kits.k02Scout;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;

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

                // Archer
                case ARROW -> {
                    Bukkit.getLogger().info("Archer Choose");
                    p.closeInventory();
                    removeEffects(p);
//                    Inventory storage = Bukkit.createInventory(p, 27);
//                    storage.setContents(p.getInventory().getContents());
                    Inventory storage = Bukkit.createInventory(p, InventoryType.PLAYER);
                    storage.setContents(p.getInventory().getContents());

                    TimelessPvP5.addEntryInvs(p.getUniqueId(), storage, p.getLocation());
                    p.getInventory().clear();
                    k01Archer.giveKit(p);
                }

                // Scout
                case BLACK_STAINED_GLASS -> {
                    Bukkit.getLogger().info("Scout Choose");
                    p.closeInventory();
                    removeEffects(p);
                    k02Scout.giveKit(p);
                }
            }

            Bukkit.getLogger().info(String.valueOf(e.getRawSlot()));

            if (e.getRawSlot() < 27) {
                e.setCancelled(true);
            }

        }


        // Cancels the event but actually means you can't move it
    }

    public static void removeEffects(Player p) {
        for (PotionEffect effect : p.getActivePotionEffects())
            p.removePotionEffect(effect.getType());
    }

}
