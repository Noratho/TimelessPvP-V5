package me.timelesspvp.timelesspvp5;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class helperMethods {


    public static void removeEffects(Player p) {
        for (PotionEffect effect : p.getActivePotionEffects())
            p.removePotionEffect(effect.getType());
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
}
