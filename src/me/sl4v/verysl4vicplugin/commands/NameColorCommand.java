package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import me.sl4v.verysl4vicplugin.utils.NameColorUtils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import sun.java2d.loops.FillRect;

import java.util.Arrays;


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
                if (!player.isOp())
                {
                    GeneralUtils.showErrorToPlayer(player, GeneralUtils.noOPError);
                    return true;
                }
                ChatColor new_color = ChatColor.WHITE;
                try
                {
                    new_color = ChatColor.valueOf(args[0]);
                    if (args.length >= 1)
                    {
                        for (String playerName : Arrays.copyOfRange(args, 1, args.length))
                        {
                            player.setPlayerListName(new_color + Bukkit.getServer().getPlayer(playerName).getDisplayName());
                            player.sendMessage(NameColorUtils.setPlayerNameColor(new_color, player.getDisplayName()));
                        }
                    }
                }   catch (Exception e)
                {
                    GeneralUtils.showErrorToPlayer(
                            player,
                            "Invalid color or player name"
                    );
                    return false;
                }

                /*
                // Debug stuff
                for (int i = 0; args.length > i; i++)
                {
                    System.out.println("ARG[" + i + "] " + args[i]);
                }
                */
            } else if (command.getName().equals("namecolorList"))
            {
                if (!player.isOp())
                {
                    GeneralUtils.showErrorToPlayer(player, GeneralUtils.noOPError);
                    return true;
                }
                player.sendMessage(NameColorUtils.getChatColorNamesMessage());
            }
        }
        return true;
    }
}