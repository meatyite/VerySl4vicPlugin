package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityShootBowEvent;

import java.util.*;


public class BowShootUtils
{

    public static Map<String, EntityType> playerEntityShootMap = new HashMap<String, EntityType>();

    public static boolean isEntityPlayer(EntityShootBowEvent event) {
        return event.getEntityType() == EntityType.PLAYER;
    }

    public static EntityType getEntityTypeForPlayer(String playerName)
    {
        return BowShootUtils.playerEntityShootMap.get(playerName);
    }

    public static void setEntityTypeForPlayer(String playerName, EntityType entityType)
    {
        BowShootUtils.playerEntityShootMap.put(playerName, entityType);
    }

    public static String getEntityTypeMessage()
    {
        String msg = "Here's a list of available types of entities:\n";
        for (EntityType entityType : EntityType.values())
        {
            if (entityType.isSpawnable())
            {
                msg = msg + entityType.name() + "\n";
            }
        }
        msg = msg + "(Open chat to view all)";
        return msg;
    }

    public static String InvalidEntityError =
            "Invalid entity type.\n"
            + ChatColor.WHITE
            + "See /entitytypes for a list of valid entity types";
}
