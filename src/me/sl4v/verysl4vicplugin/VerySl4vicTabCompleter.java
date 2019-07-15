package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.utils.BowShootUtils;
import me.sl4v.verysl4vicplugin.utils.NameColorUtils;
import me.sl4v.verysl4vicplugin.utils.SpawnTreeUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.Command;

import java.util.ArrayList;
import java.util.List;

public class VerySl4vicTabCompleter implements TabCompleter{
    @Override
    public List<String> onTabComplete (CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("bowshoot"))
        {
            return BowShootUtils.getEntityTypeNames();
        } else if (command.getName().equals("treespawn"))
        {
            return SpawnTreeUtils.getTreeTypeNames();
        } else if(command.getName().equals("namecolor"))
        {
            return NameColorUtils.getColorNames();
        }
        return null;
    }
}