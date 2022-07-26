package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.*;
import me.timelesspvp.timelesspvp5.outsourceMethods.OutsourceMethods;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class RightClickListener implements Listener {

    @EventHandler
    public void useItem(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        // If player is not in the game then send don't continue
        PersistentDataContainer pNBT = p.getPersistentDataContainer();
        if (pNBT.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("out")) {
            return;
        }


        // If a right click
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK ) {

            if (!e.hasItem()) {
                return;
            }

            switch (ChatColor.stripColor(e.getItem().getItemMeta().getDisplayName())) {

                case "zzzPick a Classzzz" -> {
                    OutsourceMethods.openMenu(p);
                }

                case "Heal Token" -> {
                    OutsourceMethods.useHealToken(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "zzzPretty Boy's Pocket Pistolzzz" -> {
                    K02ScoutMethods.shootPocketPistol(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "Reload" -> {
                    K02ScoutMethods.reloadPistol(p);

                }

                case "Stick_of_Power" -> {
                    K03MelonMethods.shootEgg(p);
                }

                case "zzz1-UPzzz" -> {
                    K07WeegeeMethods.useOneUp(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "zzzMusketzzz" -> {
                    if (p.getInventory().contains(K08PirateData.getBullet())) {
                        K08PirateMethods.shootMusket(p);
                        // remove musket ball
                        for (ItemStack items : p.getInventory().getContents()) {
                            if (items == null) {continue;}
                            String name = ChatColor.stripColor(items.getItemMeta().getDisplayName());
                            if (name.equals("zzzBulletzzz")) {
                                items.setAmount(items.getAmount() - 1);
                                break;
                            }
                        }
                    } else {
                        p.playSound(p.getLocation(),
                                Sound.BLOCK_DISPENSER_FAIL, 0.9f, 1.5f);
                    }
                }

            }
        }

    }
}
