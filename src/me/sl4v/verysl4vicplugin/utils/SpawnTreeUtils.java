package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.TreeType;

import java.util.ArrayList;
import java.util.List;

public class SpawnTreeUtils
{
    public static String getTreeTypeMessage()
    {
        String msg = "Here's a list of available types of trees:\n";
        for (String treeTypeName : SpawnTreeUtils.getTreeTypeNames())
        {
            msg = msg + treeTypeName + "\n";
        }
        msg = msg + "(Open chat to view all)";
        return msg;
    }

    public static List<String> getTreeTypeNames()
    {
        List<String> treeTypeNames = new ArrayList<String>();

        for (TreeType treeType : TreeType.values())
        {
            treeTypeNames.add(treeType.name());
        }
        return treeTypeNames;
    }

}
