package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import me.sl4v.verysl4vicplugin.utils.SpawnTreeUtils;
import org.bukkit.TreeType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnTreeCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (!player.isOp())
            {
                GeneralUtils.showErrorToPlayer(player, GeneralUtils.noOPError);
                return true;
            }
            if (command.getName().equals("treetypes"))
            {
                player.sendMessage(SpawnTreeUtils.getTreeTypeMessage());
            } else if (command.getName().equals("treespawn"))
            {
                try
                {
                    TreeType treeTypeToSpawn = TreeType.valueOf(args[0]);
                    boolean treeSpawnSuccessful = player.getWorld().generateTree(player.getLocation(), treeTypeToSpawn);
                    if (treeSpawnSuccessful)
                    {
                        player.sendMessage("Tree spawn successful.");
                    } else
                    {
                        player.sendMessage("Tree spawn unsuccessful. (Are you standing on grass?)");
                    }

                } catch (Exception e)
                {
                    GeneralUtils.showErrorToPlayer(player, "Invalid tree type. See /treetypes for a list of usable tree types");
                    return false;
                }
            }
        }
        return true;
    }
}
