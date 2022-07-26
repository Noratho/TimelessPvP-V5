package me.timelesspvp.timelesspvp5.outsourceMethods;

import me.timelesspvp.timelesspvp5.helperMethods.HelperMethods;
import me.timelesspvp.timelesspvp5.TimelessPvP5;
import me.timelesspvp.timelesspvp5.dataClasses.PlayerData;
import me.timelesspvp.timelesspvp5.kits.*;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

public class OutsourceMethods {

    public static void openMenu(Player p) {
        Inventory inv = Bukkit.createInventory(p,
                27, ChatColor.DARK_AQUA + "Choose your kit");

        // Archer
        ItemStack archerSel = K01ArcherData.getSel();

        // Scout
        ItemStack scoutSel = K02ScoutData.getSel();

        // Melon
        ItemStack melonSel = K03MelonData.getSel();

        // Weegee
        ItemStack weegeeSel = K07WeegeeData.getSkull();

        // Pirate
        ItemStack pirateSel = K08PirateData.getSel();


        inv.addItem(archerSel, scoutSel, melonSel, weegeeSel, pirateSel);

        p.openInventory(inv);
    }


    public static void lobbyProtocol(Player p) {

        // Disable active reloads
        PlayerData pData = TimelessPvP5.getPlrData().get(p.getUniqueId());
        if (pData.getActiveReloads() != null){
            pData.cancelActiveReloads();
        }
        HelperMethods.removeMarks(p);

        PersistentDataContainer pNBT = p.getPersistentDataContainer();

        p.getInventory().clear();
        HelperMethods.removeEffects(p);
        p.setGameMode(GameMode.ADVENTURE);
        Location loc = HelperMethods.getLocationConfig("lobby");

        // Delay teleport by 1 tick otherwise will spawn at spawnpoint
        BukkitScheduler scheduler = TimelessPvP5.getPlugin().getServer().getScheduler();
        scheduler.runTaskLater(TimelessPvP5.getPlugin(), new Runnable() {
            @Override
            public void run() {
                p.teleport(loc);
            }
        }, 1L);

        pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING, "lobby");

        ItemStack kitOpen = new ItemStack(Material.CAKE, 1);
        ItemMeta kitOpenMeta = kitOpen.getItemMeta();
        kitOpenMeta.setDisplayName(
                ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Pick a Class" +
                        ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        kitOpen.setItemMeta(kitOpenMeta);
        p.getInventory().addItem(kitOpen);
    }


    public static void leaveProtocol(Player p) {

        // if the player has data in the map
        if (TimelessPvP5.getPlrData().containsKey(p.getUniqueId())) {
            PlayerData pData = TimelessPvP5.getPlrData().get(p.getUniqueId());

            // Remove all effects
            for (PotionEffect effect : p.getActivePotionEffects())
                p.removePotionEffect(effect.getType());

            // restore player inv, loc, gm, and disable all reload sequences
            p.getInventory().setContents(pData.getInv().getContents());
            p.teleport(pData.getLoc());
            p.setGameMode(pData.getGm());
            // disable all reloads
            if (pData.getActiveReloads() != null){
                pData.cancelActiveReloads();
            }
            TimelessPvP5.removePlrDataEntry(p.getUniqueId());

            PersistentDataContainer pNBT = p.getPersistentDataContainer();
            pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING, "out");

        } else {
            p.sendMessage("You are not in the arena/lobby");
        }
        PersistentDataContainer pNBT = p.getPersistentDataContainer();
        pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING, "out");

        HelperMethods.removeOldCombat(p);
        HelperMethods.removeMarks(p);
    }


    public static void useHealToken(Player p) {

        if (p.getHealth() + 10 > 20) {
            p.setHealth(20);
        } else {
            p.setHealth(p.getHealth() + 10);
        }

        Location loc = p.getLocation();
        loc.setY(loc.getY() + 1);
        Particle.DustOptions options =
                new Particle.DustOptions(Color.fromRGB(255, 0, 0), 0.7f);
        p.getWorld().spawnParticle(Particle.REDSTONE,
                loc,250,0.3, 0.5, 0.3, options);

    }
}
