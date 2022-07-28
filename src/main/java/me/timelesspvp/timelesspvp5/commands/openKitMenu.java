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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.io.Console;
import java.util.ArrayList;


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

            // Scout
            ItemStack scoutSel = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
            ItemMeta scoutMeta = scoutSel.getItemMeta();
            scoutMeta.setDisplayName(
                    ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                            ChatColor.WHITE + "" + ChatColor.BOLD + "Scout" +
                            ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");

            // Lore
            ArrayList<String> lore = new ArrayList<>();
            lore.add("test1");
            lore.add("test2");
//            scoutMeta.setLore(lore);



            archerSel.setItemMeta(archerMeta);
            inv.addItem(archerSel);

            scoutSel.setItemMeta(scoutMeta);
            inv.addItem(scoutSel);

            p.openInventory(inv);

        }

        return true ;
    }
}

