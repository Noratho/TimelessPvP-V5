package me.timelesspvp.timelesspvp5.dataClasses;

import org.bukkit.inventory.ItemStack;

public class ItemWSlot {

    private ItemStack item;
    private int slot;


    public ItemWSlot(ItemStack item, int slot) {
        this.item = item;
        this.slot = slot;
    }

    public ItemStack getItem() { return item; }
    public int getSlot() { return slot; }
}
