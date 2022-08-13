package me.timelesspvp.timelesspvp5.kits;

import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class k07WeegeeMethods {

    public static void weegeeShift(Player p) {
        p.setVelocity(p.getFacing().getDirection().multiply(-1.5).add(new Vector(0,0.2, 0)));
    }

    public static void useOneUp(Player p) {
        p.setHealth(20);
    }
}
