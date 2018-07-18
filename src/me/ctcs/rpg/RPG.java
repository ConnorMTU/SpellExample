package me.ctcs.rpg;

import me.ctcs.rpg.events.PlayerClick;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Connor on 5/21/2017.
 */
public class RPG extends JavaPlugin {
    me.ctcs.rpg.commands.givePlayer givePlayer = new me.ctcs.rpg.commands.givePlayer();

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerClick(), this);
        Bukkit.getServer().getLogger().info("Rpg Plugin Enabled");
    }

    @Override
    public void onDisable() {
        Bukkit.getServer().getLogger().info("Rpg Plugin Disabled");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("pyromancy")) {
            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                givePlayer.givePyroBook(player);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You cannot execute this command!");
                return true;
            }
        }

        if (cmd.getName().equalsIgnoreCase("staff")) {
            if (sender instanceof Player) {
                Player player = ((Player) sender).getPlayer();
                givePlayer.giveStaff(player);
                return true;
            } else {
                sender.sendMessage(ChatColor.RED + "You cannot execute this command!");
                return true;
            }
        }
        return false;
    }
}
