package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.Map;

public class NameColorUtils
{
    public static Map<String, ChatColor> name_colors = new HashMap<String, ChatColor>();

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
        String display_name = chatEvent.getPlayer().getDisplayName();
        chatEvent.setFormat(
                "["
                        + NameColorUtils.name_colors.get(display_name)
                        + ChatColor.BOLD
                        + display_name
                        + ChatColor.WHITE
                        + "] "
                        + chatEvent.getMessage()
        );
    }
}
