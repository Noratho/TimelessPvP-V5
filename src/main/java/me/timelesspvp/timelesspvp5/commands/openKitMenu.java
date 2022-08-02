package me.timelesspvp.timelesspvp5.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;


public class openKitMenu implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender,
                             @NotNull Command command,
                             @NotNull String label,
                             @NotNull String[] args) {

        Bukkit.getLogger().info("Kits ran");

        if (sender instanceof Player) {
            Player p = (Player) sender;
            Inventory inv = Bukkit.createInventory(p,
                    27, ChatColor.DARK_AQUA + "Choose your kit");


            // Archer
            ItemStack archerSel = new ItemStack(Material.ARROW, 1);
            ItemMeta archerMeta = archerSel.getItemMeta();
            archerMeta.setDisplayName(
                    ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                            ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Archer" +
                            ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");

            archerSel.setItemMeta(archerMeta);
            inv.addItem(archerSel);


            // Scout
            ItemStack scoutSel = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
            ItemMeta scoutMeta = scoutSel.getItemMeta();
            scoutMeta.setDisplayName(
                    ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                            ChatColor.WHITE + "" + ChatColor.BOLD + "Scout" +
                            ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");

            scoutSel.setItemMeta(scoutMeta);
            inv.addItem(scoutSel);


            p.openInventory(inv);

        }

        return true ;
    }
}

