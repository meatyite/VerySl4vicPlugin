package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.TreeType;

public class SpawnTreeUtils
{
    public static String getTreeTypeMessage()
    {
        String msg = "Here's a list of available types of trees:\n";
        for (TreeType treeType : TreeType.values())
        {
            msg = msg + treeType.name() + "\n";
        }
        msg = msg + "(Open chat to view all)";
        return msg;
    }
}
