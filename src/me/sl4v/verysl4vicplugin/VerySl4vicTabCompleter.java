package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.utils.BowShootUtils;
import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import me.sl4v.verysl4vicplugin.utils.NameColorUtils;
import me.sl4v.verysl4vicplugin.utils.SpawnTreeUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.Command;

import java.util.List;

public class VerySl4vicTabCompleter implements TabCompleter{
    @Override
    public List<String> onTabComplete (CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("bowshoot"))
        {
            if (args.length == 1)
            {
                return GeneralUtils.filterListStartingWith(BowShootUtils.getEntityTypeNames(), args[0]);
            }
            return BowShootUtils.getEntityTypeNames();
        } else if (command.getName().equals("treespawn"))
        {
            if (args.length == 1)
            {
                return GeneralUtils.filterListStartingWith(SpawnTreeUtils.getTreeTypeNames(), args[0]);
            }
            return SpawnTreeUtils.getTreeTypeNames();
        } else if(command.getName().equals("namecolor"))
        {
            if (args.length == 1)
            {
                return GeneralUtils.filterListStartingWith(NameColorUtils.getColorNames(), args[0]);
            } else if (args.length >= 2)
            {
                return GeneralUtils.getPlayerNames();
            }
            return NameColorUtils.getColorNames();
        }
        return null;
    }
}