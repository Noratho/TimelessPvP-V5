package me.timelesspvp.timelesspvp5.commands;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class reloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {

        TimelessPvP5.getPlugin().reloadConfig();

        if (sender instanceof Player) {
            Player p = (Player) sender;
            p.sendMessage(ChatColor.BLUE + "Plugin Config Reloaded");
        }
        Bukkit.getLogger().info("reload configssss");

        return true;
    }
}
