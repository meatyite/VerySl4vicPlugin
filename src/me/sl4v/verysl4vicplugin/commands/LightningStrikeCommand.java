package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.LightningStickUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningStrikeCommand implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if (sender instanceof Player)
        {
            Player player = (Player) sender;
            if (command.getName().equals("lightningStickEnable"))
            {
                LightningStickUtils.setLightningStickEnabledForPlayer(
                        player.getDisplayName(),
                        !LightningStickUtils.isLightningStickEnabled_Static(player.getDisplayName())
                );
            }
        }
        return true;
    }
}
