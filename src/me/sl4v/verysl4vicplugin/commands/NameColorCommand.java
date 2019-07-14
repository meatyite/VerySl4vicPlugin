package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import me.sl4v.verysl4vicplugin.utils.NameColorUtils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;


public class NameColorCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (command.getName().equals("namecolor"))
            {
                ChatColor new_color = ChatColor.WHITE;
                try
                {
                    new_color = ChatColor.valueOf(args[0]);
                    player.setPlayerListName(new_color + player.getDisplayName());
                }   catch (Exception e)
                {
                    GeneralUtils.showErrorToPlayer(
                            player,
                            "Must specify a valid color\n"
                                    + ChatColor.WHITE
                                    + "See /namecolorlist for a list of valid colors."
                    );
                    return false;
                }

                NameColorUtils.name_colors.put
                        (
                                player.getDisplayName(),
                                new_color
                        );
                player.sendMessage("Changed your name's color to " + new_color + new_color.name());

                /*
                // Debug stuff
                for (int i = 0; args.length > i; i++)
                {
                    System.out.println("ARG[" + i + "] " + args[i]);
                }
                */
            } else if (command.getName().equals("namecolorList"))
            {
                player.sendMessage(NameColorUtils.getChatColorNamesMessage());
            }
        }
        return true;
    }
}