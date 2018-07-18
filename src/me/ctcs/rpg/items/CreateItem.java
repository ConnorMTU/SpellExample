package me.ctcs.rpg.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by Connor on 5/21/2017.
 */
public class CreateItem {
    public void create(Player player, Material material, ChatColor color, List<String> lore, String itemName) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(color + itemName);
        meta.setLore(lore);
        item.setItemMeta(meta);
        player.getInventory().addItem(item);
    }
}
