package me.timelesspvp.timelesspvp5.kits;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class k07Weegee {

    public static void giveKit(Player p) {

        // Item
        ItemStack poltergust = getPoltergust();



        // Potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        PotionEffect pSpeed = new PotionEffect(
                PotionEffectType.SPEED,
                10000000, 2,
                false, false);

        PotionEffect pHaste = new PotionEffect(
                PotionEffectType.FAST_DIGGING,
                10000000, 9,
                false, false);

        PotionEffect pWaterB = new PotionEffect(
                PotionEffectType.WATER_BREATHING,
                10000000, 9,
                false, false);

        p.addPotionEffect(pSat);
        p.addPotionEffect(pSpeed);
        p.addPotionEffect(pHaste);
        p.addPotionEffect(pWaterB);
    }

    public static ItemStack getPoltergust() {
        ItemStack poltergust = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta poltergustMeta = poltergust.getItemMeta();
        poltergustMeta.setUnbreakable(true);
        poltergustMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        poltergustMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.BLUE + "" + ChatColor.BOLD + "Poltergust" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        poltergust.setItemMeta(poltergustMeta);
        return poltergust;
    }

    public static ItemStack get1UP() {
        ItemStack oneUP = new ItemStack(Material.RED_MUSHROOM, 1);
        ItemMeta oneUpMeta = oneUP.getItemMeta();
        oneUpMeta.setDisplayName(
                ChatColor.WHITE + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GREEN + "" + ChatColor.BOLD + "1-UP" +
                        ChatColor.WHITE + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        oneUP.setItemMeta(oneUpMeta);
        return oneUP;
    }


    public static ItemStack getSkull() {
        ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
//        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
//        chestMeta.setColor(Color.fromBGR(0x667F33));
//        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
//        chestMeta.setUnbreakable(true);
//        chest.setItemMeta(chestMeta);
        return chest;
    }


    public static ItemStack getChest() {
        ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
        chestMeta.setColor(Color.fromBGR(0x667F33));
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestMeta.setUnbreakable(true);
        chest.setItemMeta(chestMeta);
        return chest;
    }


    public static ItemStack getLegs() {
        ItemStack legs = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        ItemMeta legsMeta = legs.getItemMeta();
        legsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        legsMeta.setUnbreakable(true);
        legs.setItemMeta(legsMeta);
        return legs;
    }


    public static ItemStack getBoots() {
        ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        return boots;
    }
}
