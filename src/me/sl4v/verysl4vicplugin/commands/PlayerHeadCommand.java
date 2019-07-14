package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import me.sl4v.verysl4vicplugin.utils.PlayerHeadUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PlayerHeadCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (command.getName().equals("playerhead"))
            {
                if (args.length >= 1)
                {
                    for (String arg : args)
                    {
                        Player playerToGetHead = Bukkit.getPlayer(arg);
                        if (playerToGetHead == null)
                        {
                            GeneralUtils.showErrorToPlayer(player, "Invalid Player name: " + arg);
                        } else
                        {
                            ItemStack playerHead = PlayerHeadUtils.getPlayerHead(playerToGetHead);
                            player.getInventory().addItem(playerHead);
                        }
                    }
                } else
                {
                    ItemStack playerSkull = PlayerHeadUtils.getPlayerHead(player);
                    player.getInventory().addItem(playerSkull);
                }

            }
        }
        return true;
    }
}
