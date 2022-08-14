package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.k01ArcherData;
import me.timelesspvp.timelesspvp5.kits.k02ScoutData;
import me.timelesspvp.timelesspvp5.helperMethods;
import me.timelesspvp.timelesspvp5.kits.k07WeegeeData;
import me.timelesspvp.timelesspvp5.kits.k08PirateData;
import me.timelesspvp.timelesspvp5.outsourceMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class menu implements Listener {

    @EventHandler
    public void onKitSelect(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (ChatColor.stripColor(e.getView().getTitle()) .equalsIgnoreCase("Choose your kit")) {
            if (e.getCurrentItem() == null) {
                return;
            }

            PersistentDataContainer data = p.getPersistentDataContainer();
            String state = data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING);

            boolean haveMatched = true;
            // On kit selection
            switch (e.getCurrentItem().getType()) {

                // Archer
                case ARROW -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();
                    Location loc = helperMethods.getLocationConfig("archer");
                    p.teleport(loc);

                    k01ArcherData.giveKit(p);
                    outsourceMethods.giveOldCombat(p);
                }

                // Scout
                case BLACK_STAINED_GLASS -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    k02ScoutData.giveKit(p);
                    outsourceMethods.giveOldCombat(p);
                }
                // Weegee
                case PLAYER_HEAD -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    k07WeegeeData.giveKit(p);
                    outsourceMethods.giveOldCombat(p);
                }
                // Pirate
                case FLINT -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    k08PirateData.giveKit(p);
                    outsourceMethods.giveOldCombat(p);
                }

                default -> {
                    haveMatched = false;
                }
            }

            if (haveMatched) {
                data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "state"), PersistentDataType.STRING, "in");
            }

            Bukkit.getLogger().info(String.valueOf(e.getRawSlot()));

            if (e.getRawSlot() < 27) {
                e.setCancelled(true);
            }

        }


        // Cancels the event but actually means you can't move it
    }

}
