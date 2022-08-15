package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.helperMethods;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class k07WeegeeData {

    public static void giveKit(Player p) {

        // Item
        ItemStack poltergust = getPoltergust();
        ItemStack oneUp =  get1UP();
        p.getInventory().addItem(poltergust, oneUp);


        // Armor
        ItemStack skull = getSkull();
        ItemStack chest = getChest();
        ItemStack legs = getLegs();
        ItemStack boots = getBoots();

        p.getInventory().setItem(EquipmentSlot.HEAD, skull);
        p.getInventory().setItem(EquipmentSlot.CHEST, chest);
        p.getInventory().setItem(EquipmentSlot.LEGS, legs);
        p.getInventory().setItem(EquipmentSlot.FEET, boots);



        // Potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        PotionEffect pSpeed = new PotionEffect(
                PotionEffectType.SPEED,
                10000000, 1,
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

        // loc
        Location loc = helperMethods.getLocationConfig("weegee");
        p.teleport(loc);
    }

    public static ItemStack getPoltergust() {
        ItemStack poltergust = new ItemStack(Material.FISHING_ROD, 1);
        ItemMeta poltergustMeta = poltergust.getItemMeta();
        poltergustMeta.setUnbreakable(true);
        poltergustMeta.addEnchant(Enchantment.DAMAGE_ALL, 10, true);
        poltergustMeta.setDisplayName(
                        ChatColor.BLUE + "" + ChatColor.BOLD + "Poltergust");
        poltergust.setItemMeta(poltergustMeta);
        return poltergust;
    }

    public static ItemStack get1UP() {
        ItemStack oneUP = new ItemStack(Material.RED_MUSHROOM, 1);
        ItemMeta oneUpMeta = oneUP.getItemMeta();
        oneUpMeta.setDisplayName(
                ChatColor.WHITE + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "1-UP" +
                        ChatColor.WHITE + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        oneUP.setItemMeta(oneUpMeta);
        return oneUP;
    }

    public static ItemStack getSkull() {
        ItemStack weegeeSkull = new ItemStack(Material.PLAYER_HEAD);
        Bukkit.getUnsafe().modifyItemStack(weegeeSkull,
    "{SkullOwner: {Name:\"Weegee\"," +
            "Properties: {textures: [{Signature: \"" +
            "iJXpJB2B84jxb0lZ8NrvvowQKE9Ig98uBLASCb8OEWUT350GmcCvn5fGvBYY+sN" +
            "WhbvWKEcxk1ixjgvx7pK7fn4FpDqG+zKdGHt2RO+xHS8oPNsqIVD91tO3yRoQIPq" +
            "vZaCV5mvhLL3WG0cy7i9D32VMOx9GEEJ+QfyqVVOsLNN5gg7Oz4kzDxowvVnKNo/" +
            "uc9ua8c6Fbuwds1M2x5E9FOSy90ziJi+RvICh6ptFfG4PL+9QFixTeUlkkfYxX4h" +
            "o90TgDYaPfMqvIvFDxfdDnmY7aBuVVWrrDlSQ+bbyx5NJKRjaMas33rvlcNUoWS" +
            "lCyNgqR0fuupIMy64H6+GAro39KOH7uqRQP75fIf4iyVhyNaSO/1fL/Hp+CR+GSA" +
            "Emypd0B/mituxBCtDo17sYig8WL5Wk6w0b19CGg/nzCEFuLVqC+rjcTZ3yKO/V6T" +
            "+eOaXceJ+bUHxAeiFB22hqnH1FV6SKZ8pTJJW2ih0SKS/J+Ic3BCfkYYgLfYEzoh" +
            "+yY6+59fuD0e/WABGGL0XgeOdENqpHcUY9Xa0BcCJPDv2/wYucL8yGhAN9RwriM" +
            "QSWB/Y5LfPlqp9iUbX22Xxgeq0/yJkCzau/oFTIu9cs+wi06I2agdvejBTYF9Q" +
            "uffjxb3sA6BIh/+v4L3WaAhG3n/txW8MCPJHhr2ZH30iE+KY=\"," +
            "Value:\"ewogICJ0aW1lc3RhbXAiIDogMTY2MDI3MTY4MTQyOSwKICAicHJvZmlsZ" +
            "UlkIiA6ICIxZTYwZTU2ZWQ3OTE0NjZkOWE2MjY0Y2Q0ZmJkMzcxZiIsCiAgInByb2Z" +
            "pbGVOYW1lIiA6ICJXZWVnZWUiLAogICJzaWduYXR1cmVSZXF1aXJlZCIgOiB0cnVl" +
            "LAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1cmwiIDogIm" +
            "h0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTk5ZTYzNGIzZDZjM" +
            "jc5NGFhY2Q3OGFkOGUyNjNkMTVkMjQ1NjQ4MjFmYWQ2MTVhZWZjNzgyZTlmNzdhNzhmM" +
            "iIKICAgIH0sCiAgICAiQ0FQRSIgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0d" +
            "XJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjM0MGMwZTAzZGQyNGExMWIxNWE4YjMzYz" +
            "JhN2U5ZTMyYWJiMjA1MWIyNDgxZDBiYTdkZWZkNjM1Y2E3YTkzMyIKICAgIH0KICB9Cn0=\"}]}}}"
        );

        ItemMeta weegeeSkullMeta = weegeeSkull.getItemMeta();
        weegeeSkullMeta.setDisplayName(
                ChatColor.GREEN + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "WEE-GEE" +
                        ChatColor.GREEN + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        weegeeSkull.setItemMeta(weegeeSkullMeta);

        return weegeeSkull;
    }

    public static ItemStack getChest() {
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
        chestMeta.setColor(Color.fromBGR(0x667F33));
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        chestMeta.setUnbreakable(true);
        chest.setItemMeta(chestMeta);
        return chest;
    }

    public static ItemStack getLegs() {
        ItemStack legs = new ItemStack(Material.GOLDEN_LEGGINGS, 1);
        ItemMeta legsMeta = legs.getItemMeta();
        legsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        legsMeta.setUnbreakable(true);
        legs.setItemMeta(legsMeta);
        return legs;
    }

    public static ItemStack getBoots() {
        ItemStack boots = new ItemStack(Material.GOLDEN_BOOTS, 1);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2, true);
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        return boots;
    }
}
