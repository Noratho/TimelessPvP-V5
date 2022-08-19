package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.*;
import me.timelesspvp.timelesspvp5.helperMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onKitSelect(InventoryClickEvent e) {

        Player p = (Player) e.getWhoClicked();

        if (ChatColor.stripColor(e.getView().getTitle()) .equalsIgnoreCase("Choose your kit")) {
            if (e.getCurrentItem() == null) {
                return;
            }

            PersistentDataContainer pNBT = p.getPersistentDataContainer();
            String state = pNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING);

            boolean haveMatched = true;
            // On kit selection
            switch (e.getCurrentItem().getType()) {

                // Archer
                case ARROW -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    K01ArcherData.giveKit(p);
                }

                // Scout
                case BLACK_STAINED_GLASS -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    K02ScoutData.giveKit(p);
                }
                // Melon
                case GLISTERING_MELON_SLICE -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    K03MelonData.giveKit(p);
                }

                // Weegee
                case PLAYER_HEAD -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    K07WeegeeData.giveKit(p);
                }
                // Pirate
                case FLINT -> {

                    p.getInventory().clear();
                    helperMethods.removeEffects(p);
                    p.closeInventory();

                    K08PirateData.giveKit(p);

                }

                default -> {
                    haveMatched = false;
                }
            }

            if (haveMatched) {
                pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                        "state"), PersistentDataType.STRING, "in");
                helperMethods.giveOldCombat(p);
            }

            Bukkit.getLogger().info(String.valueOf(e.getRawSlot()));

            if (e.getRawSlot() < 27) {
                e.setCancelled(true);
            }

        }


        // Cancels the event but actually means you can't move it
    }

}
