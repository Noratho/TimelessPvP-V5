package me.timelesspvp.timelesspvp5;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitScheduler;

public class outsourceMethods {


    public static void openMenu(Player p) {
        Inventory inv = Bukkit.createInventory(p,
                27, ChatColor.DARK_AQUA + "Choose your kit");


        // Archer
        ItemStack archerSel = new ItemStack(Material.ARROW, 1);
        ItemMeta archerMeta = archerSel.getItemMeta();
        archerMeta.setDisplayName(
                ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Archer" +
                        ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        archerSel.setItemMeta(archerMeta);


        // Scout
        ItemStack scoutSel = new ItemStack(Material.BLACK_STAINED_GLASS, 1);
        ItemMeta scoutMeta = scoutSel.getItemMeta();
        scoutMeta.setDisplayName(
                ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz" +
                        ChatColor.WHITE + "" + ChatColor.BOLD + "Scout" +
                        ChatColor.BLACK + "" + ChatColor.MAGIC + ChatColor.BOLD + "zzz");
        scoutSel.setItemMeta(scoutMeta);


        inv.addItem(archerSel, scoutSel);

        p.openInventory(inv);
    }


    public static void lobbyProtocol(Player p) {

        PersistentDataContainer data = p.getPersistentDataContainer();

        p.getInventory().clear();
        helperMethods.removeEffects(p);
        p.setGameMode(GameMode.ADVENTURE);
        Location loc = helperMethods.getLocationConfig("lobby");

        // Delay teleport by 1 tick otherwise will spawn at spawnpoint
        BukkitScheduler scheduler = TimelessPvP5.getPlugin().getServer().getScheduler();
        scheduler.runTaskLater(TimelessPvP5.getPlugin(), new Runnable() {
            @Override
            public void run() {
                p.teleport(loc);
            }
        }, 1L);

        data.set(new NamespacedKey(TimelessPvP5.getPlugin(),
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

        // if the player has data in the inv map
        if (TimelessPvP5.getPlrData().containsKey(p.getUniqueId())) {
            playerData data = TimelessPvP5.getPlrData().get(p.getUniqueId());

            for (PotionEffect effect : p.getActivePotionEffects())
                p.removePotionEffect(effect.getType());

            p.getInventory().setContents(data.getInv().getContents());
            p.teleport(data.getLoc());
            p.setGameMode(data.getGm());
            TimelessPvP5.removePlrDataEntry(p.getUniqueId());

            PersistentDataContainer pData = p.getPersistentDataContainer();
            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING, "out");

        } else {
            p.sendMessage("You are not in the arena");
        }
        PersistentDataContainer pData = p.getPersistentDataContainer();
        pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "state"), PersistentDataType.STRING, "out");

        removeOldCombat(p);
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

    public static void giveOldCombat(Player p) {
        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16);
    }


    public static void removeOldCombat(Player p) {
        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);
    }
}
