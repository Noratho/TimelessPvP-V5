package me.timelesspvp.timelesspvp5.helperMethods;

import me.timelesspvp.timelesspvp5.TimelessPvP5;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;

public class HelperMethods {


    public static void removeEffects(Player p) {
        for (PotionEffect effect : p.getActivePotionEffects())
            p.removePotionEffect(effect.getType());
    }

    public static void removeMarks(Player p) {
        PersistentDataContainer pNBT = p.getPersistentDataContainer();
        pNBT.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                "melonMarked"), PersistentDataType.BYTE, (byte) 0);
    }

    public static Location getLocationConfig(String kit) {

        double x = TimelessPvP5.getPlugin().getConfig().getDouble("spawns." + kit + ".px");
        double y = TimelessPvP5.getPlugin().getConfig().getDouble("spawns." + kit + ".py");
        double z = TimelessPvP5.getPlugin().getConfig().getDouble("spawns." + kit + ".pz");
        double yaw = TimelessPvP5.getPlugin().getConfig().getDouble("spawns." + kit + ".yaw");
        double pitch = TimelessPvP5.getPlugin().getConfig().getDouble("spawns." + kit + ".pitch");

        return new Location(Bukkit.getWorld("world"), x, y, z,
                (float) yaw, (float) pitch);
    }

    public static void giveOldCombat(Player p) {
        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(16);
    }
    public static void removeOldCombat(Player p) {
        p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4);
    }
}
