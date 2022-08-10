package me.timelesspvp.timelesspvp5.kits;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.ItemWSlot;
import me.timelesspvp.timelesspvp5.dataClasses.RunnableData;
import me.timelesspvp.timelesspvp5.dataClasses.SoundData;
import me.timelesspvp.timelesspvp5.helperMethods;
import org.bukkit.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.javatuples.Pair;

import java.util.ArrayList;

public class k02Scout {

    public static void giveKit(Player p) {

        // Items

            //holy mackerel
        ItemStack holyMackerel = getHolyMack();

            // pocket pistol
        ItemStack pocketPistol = getPocketPistol(48);

            // reload
        ItemStack reload = getReload();

        p.getInventory().addItem(holyMackerel, pocketPistol, reload);


        //Armor

            // Skull
        ItemStack nateSkull = getSkull();

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


        // Persistent data
        PersistentDataContainer data = p.getPersistentDataContainer();
        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "k02ScoutStacks"), PersistentDataType.INTEGER, 0);


        // Spawn Location
        Location loc = helperMethods.getLocationConfig("scout");
        p.teleport(loc);
    }


    public static ItemStack getPocketPistol(int amount) {
        ItemStack pocketPistol = new ItemStack(Material.STICK, amount);
        ItemMeta pocketPistolMeta = pocketPistol.getItemMeta();
        pocketPistolMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Pretty Boy's Pocket Pistol" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        pocketPistol.setItemMeta(pocketPistolMeta);

        return pocketPistol;
    }


    public static ItemStack getHolyMack() {
        ItemStack holyMackerel = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta holyMackerelMeta = holyMackerel.getItemMeta();
        holyMackerelMeta.setUnbreakable(true);
        holyMackerelMeta.addEnchant(Enchantment.DAMAGE_ALL, 4, true);
        holyMackerelMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.GOLD + "" + ChatColor.BOLD + "Holy Mackerel" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        holyMackerel.setItemMeta(holyMackerelMeta);
        return holyMackerel;
    }


    public static ItemStack getReload() {
        ItemStack reload = new ItemStack(Material.FEATHER, 1);
        ItemMeta reloadMeta = reload.getItemMeta();
        reloadMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Reload" );
        reload.setItemMeta(reloadMeta);
        return reload;
    }

    public static ItemStack getSkull() {
        ItemStack nateSkull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta nateSkullMeta = (SkullMeta) nateSkull.getItemMeta();
        nateSkullMeta.setOwner("SmittyMon");
        nateSkull.setItemMeta(nateSkullMeta);
        return nateSkull;
    }

    public static ArrayList<Pair<Long, RunnableData>> getScoutReloadSequence() {
        ArrayList<Pair<Long, RunnableData>> rData = new ArrayList<>();

        SoundData[] emptySound = {};
        PotionEffect[] emptyEffects = {};
        ItemWSlot[] emptyItems = {};

        SoundData[] sounds;
        PotionEffect[] effects;
        ItemWSlot[] items;

        RunnableData currentDataChunk;


        // Delay 20 ticks
        sounds = new SoundData[]{
                new SoundData(Sound.BLOCK_PISTON_CONTRACT, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, emptyItems);
        rData.add(new Pair<>(20L, currentDataChunk));


        // Delay 30-90 ticks
        sounds = new SoundData[] {
                new SoundData(Sound.ENTITY_ITEM_PICKUP, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, emptyItems);
        for (long delay = 25L; delay <= 97L; delay += 4)
            rData.add(new Pair<>(delay, currentDataChunk));


        // Delay 94 ticks
        sounds = new SoundData[] {
                new SoundData(Sound.BLOCK_PISTON_EXTEND, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, emptyItems);
        rData.add(new Pair<>(99L, currentDataChunk));


        //Delay 97
        items = new ItemWSlot[] {
                new ItemWSlot(getHolyMack(), -1),
                new ItemWSlot(getPocketPistol(48), -1),
                new ItemWSlot(getReload(), -1)
        };

        currentDataChunk = new RunnableData(emptySound, emptyEffects, items);
        rData.add(new Pair<>(100L, currentDataChunk));


        return rData;
    }
}
