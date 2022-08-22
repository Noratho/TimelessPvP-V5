package me.timelesspvp.timelesspvp5.commands;

import me.timelesspvp.timelesspvp5.outsourceMethods.OutsourceMethods;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LeaveArenaCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {


        if (sender instanceof Player) {
            Player p = (Player) sender;

            OutsourceMethods.leaveProtocol(p);
        }

        return true;
    }
}
