package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.TeleportUtils;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;


public class RandomTeleportCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (command.getName().equals("randtp"))
        {
            if (sender instanceof Player)
            {
                Player player = (Player) sender;
                //Safe Location that has been generated
                Location randomLocation = TeleportUtils.findSafeLocation(player);
                //Teleport player
                player.teleport(randomLocation);
                player.sendMessage(ChatColor.RED + "Teleported to Random Location.");

                String new_coordinates_message = ChatColor.AQUA
                        + "New Coordinates: "
                        + ChatColor.LIGHT_PURPLE
                        + randomLocation.getX()
                        + " "
                        + randomLocation.getY()
                        + " "
                        + randomLocation.getZ();

                player.sendMessage(new_coordinates_message);
            }
        }

        return true;
    }
}