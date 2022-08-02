package me.timelesspvp.timelesspvp5;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;

public class healToken {


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
