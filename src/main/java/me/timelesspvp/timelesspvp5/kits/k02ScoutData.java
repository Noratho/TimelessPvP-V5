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

import java.io.File;
import java.util.ArrayList;

public class k02ScoutData {

    public static void giveKit(Player p) {

        // Items

        ItemStack holyMackerel = getHolyMack();
        ItemStack pocketPistol = getPocketPistol(48);
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
        holyMackerelMeta.addEnchant(Enchantment.DAMAGE_ALL, 3, true);
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
        Bukkit.getUnsafe().modifyItemStack(nateSkull,
    "{SkullOwner: {Name: \"SmittyMon\", " +
            "Properties: {textures: [{Value: \"ewogICJ0aW1lc3RhbXAiIDogMTY1" +
            "OTc3Mzc2MDIwMiwKICAicHJvZmlsZUlkIiA6ICIwMDkwZWYxNzRjNGI0NjFmOTZjNzYw" +
            "ZWEwZmQwYjljZiIsCiAgInByb2ZpbGVOYW1lIiA6ICJTbWl0dHlNb24iLAogICJzaW" +
            "duYXR1cmVSZXF1aXJlZCIgOiB0cnVlLAogICJ0ZXh0dXJlcyIgOiB7CiAgICAiU0tJTi" +
            "IgOiB7CiAgICAgICJ1cmwiIDogImh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3" +
            "RleHR1cmUvNDhkOTM4YzRlZmExOTVmZGJmNTNhMzAzYWJhNmIwMjMwZDRiMjk5MmYyYz" +
            "UwNzVhMTI0MWNkNzQ4ZDM0MGNiZSIKICAgIH0KICB9Cn0=\", Signature: \"Miue4" +
            "Rp1tAEQNuGrRmRJOZb1SfgXINLTzzo8P/pOq39JjVo2QzGRwznwRbLJi+yudgSVu2/LV" +
            "dhzE3Z5vMDZu2EB3+/ZmcDgU0bVnQsasIUjprhGpE4hGcWgB1sTHzN+nY8hBhZ7Dx56t" +
            "wTRWoRvGouppTaxT6sOWKvv8AVX7xj7U9yvb91XhT/fWUm1xDejyWJ3epCAvFCVqQlDm" +
            "bWko+5EBhe3hN//SoCLNq3LkLhVsJRyeymKioyz9UgkY32VpgGrmUkyY0EXkFQgkd1VV" +
            "3BBbCLxYF6r+Fzi9fOSp6v0AtvKbwBSVcn2qtAvpEO1ncjEHPqoqyQa2zqWoME8TlL5x" +
            "gOGhOXY1/KHQ4jnSdI8oCauqUN+lH4q2/Qi4okSP7p3p2FB4W/rq2ZoG/ne+tJHF241R" +
            "RiZE+mAt85EZEMni1viYxlFa5somwaFyjaLvUWD4TkWXKmCYBbVMH1XE/p8jeot2VS8e" +
            "Qi6MWf5WpytbHHHQ5sHB/HmC8JOCuQjWwMwsQOlHZvAsGNdT2qv1ER6A6PUxiloWlxjh" +
            "xSuTy9jQx0giFbjDfnNG06In2F9DjxrMZzbPaTZz/ByaL4IyjyFDxTuGfK0lGGper+NO" +
            "gb3O94qHHctuAYIc7sMCFGD2ZChwH+lX18t/dMGGX7Jv293dlZTZgV2Nzm463NyW/I=\"" +
            "}]}}}"
        );
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
        rData.add(new Pair<>(5L, currentDataChunk));


        // Delay 30-90 ticks
        sounds = new SoundData[] {
                new SoundData(Sound.ENTITY_ITEM_PICKUP, 1, 1)
        };

        currentDataChunk = new RunnableData(sounds, emptyEffects, emptyItems);
        for (long delay = 9L; delay <= 97L; delay += 4)
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
