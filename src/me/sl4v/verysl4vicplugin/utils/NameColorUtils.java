package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameColorUtils
{
    public static Map<String, ChatColor> name_colors = new HashMap<String, ChatColor>();

    public static List<String> getColorNames()
    {
        List<String> colorNames = new ArrayList<String>();
        for (ChatColor color : ChatColor.values())
        {
            colorNames.add(color.name());
        }
        return colorNames;
    }


    public static String getChatColorNamesMessage()
    {
        ChatColor[] chatColors = ChatColor.values();
        String msg = "Here's a list of available name colors:\n";

        for (ChatColor color : chatColors)
        {
            String colorName = color + color.name();
            if (color == ChatColor.MAGIC)
            {
                colorName = color + color.name() + color.WHITE + " (MAGIC)";
            }
            msg = msg + colorName + ChatColor.WHITE +"\n";
        }
        msg += "(Open chat to view all)";
        return msg;
    }

    public static void setMessageFormat(AsyncPlayerChatEvent chatEvent)
    {
        String chatFormat =
                "["
                + NameColorUtils.getPlayerNameWithColor(chatEvent.getPlayer().getDisplayName(), true)
                + ChatColor.WHITE
                + "] "
                + chatEvent.getMessage();

        chatEvent.setFormat(chatFormat);
    }

    private static ChatColor getPlayerNameColor(String playerName)
    {
        ChatColor nameColor = NameColorUtils.name_colors.get(playerName);
        if (nameColor != null)
        {
            return nameColor;
        }
        else
        {
            return ChatColor.WHITE;
        }
    }

    public static String setPlayerNameColor(ChatColor nameColor, String playerName)
    {
        NameColorUtils.name_colors.put(playerName, nameColor);
        return "Set " + playerName + "'s name color to " + nameColor + nameColor.name();
    }

    public static String getPlayerNameWithColor(String playerName, boolean bold)
    {
        String newPlayerName = NameColorUtils.getPlayerNameColor(playerName) + "";
        // The string in the end is there so it
        // won't error because it's not a string but a ChatColor object
        if (bold)
        {
            newPlayerName = newPlayerName + ChatColor.BOLD;
        }
        return newPlayerName + playerName;
    }
}
