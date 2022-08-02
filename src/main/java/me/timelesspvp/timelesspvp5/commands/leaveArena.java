package me.timelesspvp.timelesspvp5.commands;

import it.unimi.dsi.fastutil.Pair;
import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.leaveExecute;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class leaveArena implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            leaveExecute.leaveArena(p);
        }

        return true;
    }
}
