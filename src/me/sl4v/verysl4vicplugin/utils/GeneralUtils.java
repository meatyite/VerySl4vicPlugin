package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

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

    public static String noOPError = "You need to be OP to execute this command.";

    public static List<String> filterListStartingWith(List<String> list, String startsWith)
    {
        List<String> filteredList = new ArrayList<String>();

        for (String unfilteredString : list)
        {
            if (unfilteredString.startsWith(startsWith))
            {
                filteredList.add(unfilteredString);
            }
        }
        return filteredList;
    }

    public static List<String> getPlayerNames()
    {
        List<String> playerNames = new ArrayList<String>();

        for (Player player : Bukkit.getServer().getOnlinePlayers())
        {
            playerNames.add(player.getDisplayName());
        }
        return playerNames;
    }

}
