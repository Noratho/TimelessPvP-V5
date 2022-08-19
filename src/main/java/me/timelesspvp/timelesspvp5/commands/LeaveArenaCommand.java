package me.timelesspvp.timelesspvp5.commands;

import me.timelesspvp.timelesspvp5.outsourceMethods;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class LeaveArenaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            outsourceMethods.leaveProtocol(p);
        }

        return true;
    }
}
