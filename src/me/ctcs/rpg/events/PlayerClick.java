package me.ctcs.rpg.events;

import me.ctcs.rpg.spells.PyroSpells;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

/**
 * Created by Connor on 5/21/2017.
 */
public class PlayerClick implements Listener {
    PyroSpells pSpell = new PyroSpells();

    @EventHandler
    public void onClickEvent(PlayerInteractEvent event) {
        if (event.getHand() == EquipmentSlot.OFF_HAND)
            return;

        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) || event.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().hasItemMeta() &&
                    player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Staff")) {
                if (player.getInventory().getItemInOffHand().hasItemMeta() &&
                        player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Pyromancy Spells")) {
                    pSpell.cast(event.getPlayer());
                }
            }
        }

        if (event.getAction().equals(Action.LEFT_CLICK_BLOCK) || event.getAction().equals(Action.LEFT_CLICK_AIR)) {
            Player player = event.getPlayer();
            if (player.getInventory().getItemInMainHand().hasItemMeta() &&
                    player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.BLUE + "Staff")) {
                if (player.getInventory().getItemInOffHand().hasItemMeta() &&
                        player.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "Pyromancy Spells")) {
                    pSpell.spellSwitch(event.getPlayer());
                }
            }
        }
    }
}
