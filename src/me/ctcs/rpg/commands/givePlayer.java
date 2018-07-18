package me.ctcs.rpg.commands;

import me.ctcs.rpg.items.CreateItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Connor on 5/21/2017.
 */
public class givePlayer {
    CreateItem obj = new CreateItem();
    public void givePyroBook(Player player) {
        if (player.hasPermission("rpg.pyrobook")) {
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "Gives you access to the pyromancy class of spells");
            obj.create(player, Material.BOOK, ChatColor.RED, lore, "Pyromancy Spells");
        } else {
            player.sendMessage(ChatColor.RED + "You do not have access to this command.");
        }
    }

    public void giveStaff(Player player) {
        if (player.hasPermission("rpg.staff")) {
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "Gives you access to spell casting abilities");
            obj.create(player, Material.STICK, ChatColor.BLUE, lore, "Staff");
        } else {
            player.sendMessage(ChatColor.RED + "You do not have access to this command.");
        }
    }
}
