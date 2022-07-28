package me.timelesspvp.timelesspvp5.kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Skull;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.UUID;

public class k02Scout {

    public static void giveKit(Player p) {

        // Items

            //holy mackerel
        ItemStack holyMackerel = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta holyMackerelMeta = holyMackerel.getItemMeta();
        holyMackerelMeta.setUnbreakable(true);
        holyMackerelMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        holyMackerelMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Holy Mackerel" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        holyMackerel.setItemMeta(holyMackerelMeta);

            // pocket pistol
        ItemStack pocketPistol = new ItemStack(Material.STICK, 48);
        ItemMeta pocketPistolMeta = pocketPistol.getItemMeta();
        pocketPistolMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Pretty Boy's Pocket Pistol" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        pocketPistol.setItemMeta(pocketPistolMeta);

            // reload
        ItemStack reload = new ItemStack(Material.FEATHER, 1);
        ItemMeta reloadMeta = reload.getItemMeta();
        pocketPistolMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Pretty Boy's Pocket Pistol" );
        reload.setItemMeta(reloadMeta);

        p.getInventory().addItem(holyMackerel, pocketPistol);


        //Armor

            // Skull
        ItemStack nateSkull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta nateSkullMeta = (SkullMeta) nateSkull.getItemMeta();
//        nateSkullMeta.setOwningPlayer(Bukkit.getPlayer(
//                UUID.fromString("0090ef17-4c4b-461f-96c7-60ea0fd0b9cf")));
        nateSkullMeta.setOwner("SmittyMon");
        nateSkull.setItemMeta(nateSkullMeta);

        p.getInventory().setItem(EquipmentSlot.HEAD, nateSkull);


        // Potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        PotionEffect pSpeed = new PotionEffect(
                PotionEffectType.SPEED,
                10000000, 3,
                false, false);

        p.addPotionEffect(pSat);
        p.addPotionEffect(pSpeed);


        // Spawn Location
    }
}
