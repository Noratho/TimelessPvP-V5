package me.timelesspvp.timelesspvp5;

import it.unimi.dsi.fastutil.Pair;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;

public class outsourceMethods {

    public static void lobbyProtocol(Player p) {

    }


    public static void leaveProtocol(Player p) {
        // if the player has data in the inv map
        if (TimelessPvP5.getInvs().containsKey(p.getUniqueId())) {
            Pair<Inventory, Location> data = TimelessPvP5.getInvs().get(p.getUniqueId());

            for (PotionEffect effect : p.getActivePotionEffects())
                p.removePotionEffect(effect.getType());

            p.getInventory().setContents(data.first().getContents());
            p.teleport(data.second());
            TimelessPvP5.removeEntryInvs(p.getUniqueId());

            PersistentDataContainer pData = p.getPersistentDataContainer();
            pData.set(new NamespacedKey(TimelessPvP5.getPlugin(),
                    "state"), PersistentDataType.STRING, "out");

        } else {
            p.sendMessage("You are not in the arena");
        }
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
