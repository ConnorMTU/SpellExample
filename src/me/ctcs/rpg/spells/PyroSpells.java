package me.ctcs.rpg.spells;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Connor on 5/22/2017.
 */
public class PyroSpells {
    HashMap currentSpell = new HashMap(200);

    public void spellSwitch(Player player) {
        UUID pID = player.getUniqueId();

        if (!currentSpell.containsKey(pID))
            currentSpell.put(pID, 1);

        if (currentSpell.containsKey(pID)) {
            int spell = Integer.parseInt(currentSpell.get(pID).toString());
            switch (spell) {
                case 1: currentSpell.replace(pID, 1, 2);
                        player.sendMessage((ChatColor.GREEN + "You've switched to Fire Storm!"));
                        break;
                case 2: currentSpell.replace(pID, 2, 3);
                        player.sendMessage(ChatColor.GREEN + "You've switched to Fire Shield!");
                        break;
                case 3: currentSpell.replace(pID, 3, 1);
                        player.sendMessage(ChatColor.GREEN + "You've switched to Fire Bolt!");
                        break;
            }
        } else {
            currentSpell.put(pID, 1);
            player.sendMessage(ChatColor.GREEN + "You've switched to Fire Bolt!@");
        }
    }

    public void cast(Player player) {
        UUID pID = player.getUniqueId();

        if (!currentSpell.containsKey(pID))
            currentSpell.put(pID, 1);

        switch (Integer.parseInt(currentSpell.get(pID).toString())) {
            case 1: fireBolt(player);
                break;
            case 2: fireStorm(player);
                break;
            case 3: fireShield(player);
                break;
        }
    }

    public void fireBolt(Player player) {
        player.sendMessage(ChatColor.RED + "You've cast Fire Bolt!");
    }

    public void fireStorm(Player player) {
        player.sendMessage(ChatColor.RED + "You've cast Fire Storm!");
    }

    public void fireShield(Player player) {
        player.sendMessage(ChatColor.RED + "You've cast Fire Shield!");
    }

    /* Goals

    - Spell switching, three spells at least
        - Firebolt
            - Firework to a location, entities within 2 blocks take 6 damage and fire ticks for 3 seconds
            - Cooldown 8 seconds
        - Firestorm
            - Blast of fire around your location, any entity within 4 blocks of you takes 8 damage, ticks fire for 4 seconds
            - Cooldown 15 seconds
        - Fireshield
            - Shield of fire for 4 seconds, immune to fire damage, any entity within 1 block of you ticks for 1 damage each second.
            - Entites touched by the flame will tick fire for 5 seconds
            - Cooldown 45 seconds
     */
}
