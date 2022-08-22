package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.dataClasses.ItemWSlot;
import me.timelesspvp.timelesspvp5.dataClasses.RunnableData;
import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import me.timelesspvp.timelesspvp5.helperMethods.HelperMethods;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.javatuples.Pair;

import java.util.ArrayList;

public class K08PirateData {

    public static void giveKit(Player p) {

        // item
        ItemStack cutlass = getCutlass();
        ItemStack musket = getMusket();
        ItemStack bullet = getBullet();
        p.getInventory().addItem(cutlass, musket, bullet);


        // Armor
        ItemStack cap = getCap();
        ItemStack chest = getChest();
        ItemStack legs = getLegs();
        ItemStack boots = getBoots();

        p.getInventory().setItem(EquipmentSlot.HEAD, cap);
        p.getInventory().setItem(EquipmentSlot.CHEST, chest);
        p.getInventory().setItem(EquipmentSlot.LEGS, legs);
        p.getInventory().setItem(EquipmentSlot.FEET, boots);


        // potion
        PotionEffect pSat = new PotionEffect(
                PotionEffectType.SATURATION,
                10000000, 0,
                false, false);

        p.addPotionEffect(pSat);

        // loc
        Location loc = HelperMethods.getLocationConfig("pirate");
        p.teleport(loc);
    }
    public static ItemStack getSel() {
        ItemStack pirateSel = new ItemStack(Material.FLINT, 1);
        ItemMeta pirateSelMeta = pirateSel.getItemMeta();
        pirateSelMeta.setDisplayName(
                ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GRAY + "" + ChatColor.BOLD + "Pirate" +
                        ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        pirateSel.setItemMeta(pirateSelMeta);
        return pirateSel;
    }

    public static ItemStack getCutlass() {

        ItemStack cutlass = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta cutlassMeta = cutlass.getItemMeta();
        cutlassMeta.setUnbreakable(true);
        cutlassMeta.addEnchant(Enchantment.FIRE_ASPECT, 1, true);
        cutlassMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
        cutlassMeta.setDisplayName(
                ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GRAY + "" + ChatColor.BOLD + "Cutlass" +
                        ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        cutlass.setItemMeta(cutlassMeta);
        return cutlass;
    }
    public static ItemStack getMusket() {

        ItemStack musket = new ItemStack(Material.IRON_HORSE_ARMOR, 1);
        ItemMeta musketMeta = musket.getItemMeta();
        musketMeta.setUnbreakable(true);
        musketMeta.addEnchant(Enchantment.LUCK, 10, true);
        musketMeta.setDisplayName(
                ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GRAY + "" + ChatColor.BOLD + "Musket" +
                        ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        musket.setItemMeta(musketMeta);
        return musket;
    }
    public static ItemStack getBullet() {

        ItemStack bullet = new ItemStack(Material.IRON_NUGGET, 1);
        ItemMeta bulletMeta = bullet.getItemMeta();
        bulletMeta.setDisplayName(
                ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GRAY + "" + ChatColor.BOLD + "Bullet" +
                        ChatColor.RED + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        bullet.setItemMeta(bulletMeta);
        return bullet;
    }

    public static ItemStack getCap() {
        ItemStack cap = new ItemStack(Material.CHAINMAIL_HELMET, 1);
        ItemMeta capMeta = cap.getItemMeta();
        capMeta.addEnchant(Enchantment.OXYGEN, 1, true);
        capMeta.setUnbreakable(true);
        cap.setItemMeta(capMeta);
        return cap;
    }
    public static ItemStack getChest() {
        ItemStack chest = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
        ItemMeta chestMeta = chest.getItemMeta();
        chestMeta.addEnchant(Enchantment.LUCK, 5, true);
        chestMeta.setUnbreakable(true);
        chest.setItemMeta(chestMeta);
        return chest;
    }
    public static ItemStack getLegs() {
        ItemStack legs = new ItemStack(Material.CHAINMAIL_LEGGINGS, 1);
        ItemMeta legsMeta = legs.getItemMeta();
        legsMeta.addEnchant(Enchantment.LURE, 5, true);
        legsMeta.setUnbreakable(true);
        legs.setItemMeta(legsMeta);
        return legs;
    }
    public static ItemStack getBoots() {
        ItemStack boots = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        ItemMeta bootsMeta = boots.getItemMeta();
        bootsMeta.addEnchant(Enchantment.DEPTH_STRIDER, 3, true);
        bootsMeta.setUnbreakable(true);
        boots.setItemMeta(bootsMeta);
        return boots;
    }

    public static ArrayList<Pair<Long, RunnableData>> getReloadSequence() {
        ArrayList<Pair<Long, RunnableData>> rData = new ArrayList<>();

        SoundData[] emptySound = {};
        PotionEffect[] emptyEffects = {};
        ItemWSlot[] emptyItems = {};

        SoundData[] sounds;
        PotionEffect[] effects;
        ItemWSlot[] items;

        RunnableData currentDataChunk;

        // Delay 100 ticks
        sounds = new SoundData[]{
                new SoundData(Sound.BLOCK_PISTON_CONTRACT, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, emptyItems);
        rData.add(new Pair<>(100L, currentDataChunk));

        //Delay 105
        items = new ItemWSlot[] {
                new ItemWSlot(getBullet(), -1)
        };
        sounds = new SoundData[]{
                new SoundData(Sound.BLOCK_PISTON_EXTEND, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, items);
        rData.add(new Pair<>(105L, currentDataChunk));

        return rData;
    }
}
