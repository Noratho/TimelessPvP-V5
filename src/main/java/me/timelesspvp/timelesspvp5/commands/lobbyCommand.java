package me.timelesspvp.timelesspvp5.commands;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.outsourceMethods;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import me.timelesspvp.timelesspvp5.helperMethods;

public class lobbyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {

        Player p = (Player) sender;
        PersistentDataContainer data = p.getPersistentDataContainer();

        // if state is in lobby already
        if (data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("lobby")) {
            p.sendMessage(ChatColor.BLUE + "You are already in the lobby");
            return true;
        }

        // If player is not in the game store the inv
        if (data.get(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING).equals("out")) {
            // Store inv and prev location data
            Inventory storage = Bukkit.createInventory(p, InventoryType.PLAYER);
            storage.setContents(p.getInventory().getContents());
            TimelessPvP5.addEntryInvs(p.getUniqueId(), storage, p.getLocation());
        }

        outsourceMethods.lobbyProtocol(p);

        return true;
    }

}
