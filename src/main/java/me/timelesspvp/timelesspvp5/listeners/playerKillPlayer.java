package me.timelesspvp.timelesspvp5.listeners;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class playerKillPlayer implements Listener {

    @EventHandler
    public void onKillPlayer(PlayerDeathEvent e) {

        if (e.getEntity().getKiller() != null) {

//            if (TimelessPvP5.getInvs().containsKey(p.getUniqueId())) {}

            ItemStack healToken = new ItemStack(Material.RED_DYE, 1);
            ItemMeta healTokenMeta = healToken.getItemMeta();
            healTokenMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Heal Token");
            healToken.setItemMeta(healTokenMeta);
            e.getEntity().getKiller().getInventory().addItem(healToken);
        }

    }
}
