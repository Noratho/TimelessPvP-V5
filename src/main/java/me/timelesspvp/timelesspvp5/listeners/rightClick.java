package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.kits.k07WeegeeMethods;
import me.timelesspvp.timelesspvp5.kits.k08PirateData;
import me.timelesspvp.timelesspvp5.kits.k08PirateMethods;
import me.timelesspvp.timelesspvp5.outsourceMethods;
import me.timelesspvp.timelesspvp5.kits.k02ScoutMethods;
import org.bukkit.Bukkit;
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

public class rightClick implements Listener {

    @EventHandler
    public void useItem(PlayerInteractEvent e) {

        Player p = e.getPlayer();

        // If player is not in the game then send don't continue
        PersistentDataContainer perData = p.getPersistentDataContainer();
        if (perData.get(new NamespacedKey(TimelessPvP5.getPlugin(),
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
                    outsourceMethods.openMenu(p);
                }

                case "Heal Token" -> {
                    outsourceMethods.useHealToken(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "zzzPretty Boy's Pocket Pistolzzz" -> {
                    k02ScoutMethods.shootPocketPistol(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "Reload" -> {
                    k02ScoutMethods.reloadPistol(p);

                }

                case "zzz1-UPzzz" -> {
                    k07WeegeeMethods.useOneUp(p);
                    e.getItem().setAmount(e.getItem().getAmount() - 1);
                }

                case "zzzMusketzzz" -> {
                    if (p.getInventory().contains(k08PirateData.getBullet())) {
                        k08PirateMethods.shootMusket(p);
                        for (ItemStack items : p.getInventory().getContents()) {
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
