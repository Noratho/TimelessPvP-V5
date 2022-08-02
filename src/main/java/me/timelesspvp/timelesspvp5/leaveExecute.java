package me.timelesspvp.timelesspvp5;

import it.unimi.dsi.fastutil.Pair;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;

public class leaveExecute {

    public static void leaveArena(Player p) {
        // if the player has data in the inv map
        if (TimelessPvP5.getInvs().containsKey(p.getUniqueId())) {
            Pair<Inventory, Location> data = TimelessPvP5.getInvs().get(p.getUniqueId());

            for (PotionEffect effect : p.getActivePotionEffects())
                p.removePotionEffect(effect.getType());

            p.getInventory().setContents(data.first().getContents());
            p.teleport(data.second());
            TimelessPvP5.removeEntryInvs(p.getUniqueId());

            Bukkit.getLogger().info("Did this player leave if so why no work?");

        } else {
            p.sendMessage("You are not in the arena");
        }
    }
}
