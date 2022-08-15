package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.helperMethods;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class k03MelonData {

    public static void giveKit(Player p) {

        // Item
        ItemStack stickOfPower = getStickOfPower();
        ItemStack derpAirlines =  getDerpAirlines();
        p.getInventory().addItem(stickOfPower, derpAirlines);

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
                10000000, 2,
                false, false);

        p.addPotionEffect(pSat);
        p.addPotionEffect(pSpeed);

        // loc
        Location loc = helperMethods.getLocationConfig("melon");
        p.teleport(loc);
    }

    public static ItemStack getSel() {
        ItemStack melonSel = new ItemStack(Material.GLISTERING_MELON_SLICE, 1);
        ItemMeta melonSelMeta = melonSel.getItemMeta();
        melonSelMeta.setDisplayName(
                ChatColor.DARK_RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GREEN + "" + ChatColor.BOLD + "Melon" +
                        ChatColor.DARK_RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        melonSel.setItemMeta(melonSelMeta);
        return melonSel;
    }

    public static ItemStack getStickOfPower() {
        ItemStack stickOfPower = new ItemStack(Material.STICK, 1);
        ItemMeta stickOfPowerMeta = stickOfPower.getItemMeta();
        stickOfPowerMeta.addEnchant(Enchantment.DAMAGE_ALL, 8, true);
        stickOfPowerMeta.setDisplayName(
                ChatColor.DARK_RED + "" + ChatColor.BOLD + "Stick_of_Power");
        stickOfPower.setItemMeta(stickOfPowerMeta);
        return stickOfPower;
    }
    public static ItemStack getDerpAirlines() {
        ItemStack derpAirlines = new ItemStack(Material.MELON_SEEDS, 1);
        ItemMeta derpAirlinesMeta = derpAirlines.getItemMeta();
        derpAirlinesMeta.addEnchant(Enchantment.KNOCKBACK, 25, true);
        derpAirlinesMeta.setDisplayName(
                ChatColor.GREEN + "" + ChatColor.BOLD + "Derp_Airlines");
        derpAirlines.setItemMeta(derpAirlinesMeta);
        return derpAirlines;
    }

    public static ItemStack getSkull() {
        ItemStack melonSkull = new ItemStack(Material.PLAYER_HEAD);
        Bukkit.getUnsafe().modifyItemStack(melonSkull,
                "{SkullOwner: {Name:\"Frogboy11101\"," +
                        "Properties: {textures: [{Signature: \"" +
                        "e0mQrVmYR7nR2RW2rKuwy0VUnDz+ksHQujduNIdm0tctOtONL8MZvIS73hd3vmeL" +
                        "dEQmpFVMs+ulWXrM5Oe0Dms7vKlxgNrqCcnA28+dJ6PZwc1DQwjDHgNomL3nCgax" +
                        "3NVFw2xEtgf0P3Pfs/PhC7oZz+wXmqeaixhLek6XOyjZ+aKcQ1O/C2UPF/1Bx1JV" +
                        "NkCnXmtbORhaBjrSik9qtGbRftWaX+fFgv3jyxzxICmkkjfYXGYm/YmVOGS+e5qX" +
                        "hB3V2jpmJCl+eEmSAOchOFx7R+Bl1HcUCoLC63gamaDsAy4kRzvG3W/WjqnFATbw" +
                        "+XC6rXxl6tSCtplXDAEUgpXzE5lgV0az3M919TZk1aKfKB5KM5JKbTXKhWjziXYM" +
                        "rEXxRBQ0X8JbGUzufN96NkfaEqEn2gYwn6XmXbhhOXDCipBPVlBTiK2fOLn8GTuv" +
                        "IU25ZcteyN3eXd3ctkqqeWHbfL25JZnrq+2cH5qnPnHbwl9A9wr9J68dTFh7hsUd" +
                        "YYKkz/jeLUmo+UTW4g5MizEgxnH6mCa92EvB75kaWq1rpKQ+ApqFRPr/jsm7mqcb" +
                        "+hEfu0g3ID2G4ol9fjCU1E2h78S8cre0xxugR7GxDZb+O4dxneQjyicdb3/LUtRI" +
                        "Gs+CilUyqfGQv1JCHzxfIMOhMgUSjHDYAkpiWUF94dQ=\"," +
                        "Value:\"ewogICJ0aW1lc3RhbXAiIDogMTY2MDU0NjE1NzcyNiwKICAicHJvZmls" +
                        "ZUlkIiA6ICJhZjJlYzEwMmI2Nzc0NjM4YmY3NGUxOTgzNmNjMzFkNCIsCiAgInBy" +
                        "b2ZpbGVOYW1lIiA6ICIyMG5nc19Kb2UiLAogICJzaWduYXR1cmVSZXF1aXJlZCIg" +
                        "OiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTiIgOiB7CiAgICAgICJ1" +
                        "cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvODU1" +
                        "OWFmMjI1NzFmZTg1ZTQ0MWZhY2U0OGNiNTVkYzA3OGVkNGQ4OGQ0NmQ5YWVkZmEy" +
                        "YjVmN2M1YjA2ZDAyOSIKICAgIH0KICB9Cn0=\"}]}}}"
        );
        return melonSkull;
    }
    public static ItemStack getChest() {
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
        LeatherArmorMeta chestMeta = (LeatherArmorMeta) chest.getItemMeta();
        chestMeta.setColor(Color.fromRGB(0xFA4350));
        chestMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        chestMeta.setUnbreakable(true);
        chest.setItemMeta(chestMeta);
        return chest;
    }
    public static ItemStack getLegs() {
        ItemStack legs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
        LeatherArmorMeta legsMeta = (LeatherArmorMeta) legs.getItemMeta();
        legsMeta.setColor(Color.fromRGB(0x41EB00));
        legsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        legsMeta.setUnbreakable(true);
        legs.setItemMeta(legsMeta);
        return legs;
    }
    public static ItemStack getBoots() {
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS, 1);
        LeatherArmorMeta bootsMeta = (LeatherArmorMeta) boots.getItemMeta();
        bootsMeta.setColor(Color.fromRGB(0xFA4350));
        bootsMeta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        return boots;
    }
}
