package me.timelesspvp.timelesspvp5.kits;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class k01ArcherData {

    public static void giveKit(Player p) {

        // Items

            // Bow
        ItemStack specialDelivery = new ItemStack(Material.BOW, 1);
        ItemMeta specialDeliveryMeta = specialDelivery.getItemMeta();
        specialDeliveryMeta.setUnbreakable(true);
        specialDeliveryMeta.addEnchant(Enchantment.ARROW_DAMAGE, 7, true);
        specialDeliveryMeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
        specialDeliveryMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Special Delivery" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        specialDelivery.setItemMeta(specialDeliveryMeta);

            // Sword
        ItemStack dagger = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta daggerMeta = dagger.getItemMeta();
        daggerMeta.setUnbreakable(true);
        daggerMeta.addEnchant(Enchantment.DAMAGE_ALL, 1, true);
        daggerMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Dagger" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        dagger.setItemMeta(daggerMeta);

            // Arrow
        ItemStack arrow = new ItemStack(Material.ARROW, 1);

        p.getInventory().addItem(specialDelivery, dagger, arrow);

        // Armor

            // Helmet
        ItemStack cap = new ItemStack(Material.LEATHER_HELMET, 1);
        LeatherArmorMeta capMeta = (LeatherArmorMeta) cap.getItemMeta();
        capMeta.setColor(Color.fromBGR(0x0EA600));
        capMeta.setUnbreakable(true);
        cap.setItemMeta(capMeta);

            // Chest
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.setUnbreakable(true);
        chest.setItemMeta(chestMeta);

            // Legs
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
        legsMeta.setColor(Color.fromBGR(0x0EA600));
        legsMeta.setUnbreakable(true);
        legs.setItemMeta(legsMeta);

            // Boots
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(Color.fromBGR(0x0EA600));
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);

        p.getInventory().setItem(EquipmentSlot.HEAD, cap);
        p.getInventory().setItem(EquipmentSlot.CHEST, chest);
        p.getInventory().setItem(EquipmentSlot.LEGS, legs);
        p.getInventory().setItem(EquipmentSlot.FEET, boots);


        // Potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        p.addPotionEffect(pSat);


        // Spawn Location

    }
}
