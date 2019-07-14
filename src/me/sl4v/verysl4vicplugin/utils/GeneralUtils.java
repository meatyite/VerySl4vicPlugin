package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GeneralUtils
{
    public static void showErrorToPlayer(Player player, String error)
    {
        player.sendMessage(
                ChatColor.RED
                        + "ERROR"
                        + ChatColor.WHITE
                        + ": "
                        + ChatColor.RED
                        + error
        );
    }
}
