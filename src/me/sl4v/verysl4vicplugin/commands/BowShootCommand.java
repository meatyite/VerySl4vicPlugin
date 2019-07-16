package me.sl4v.verysl4vicplugin.commands;

import me.sl4v.verysl4vicplugin.utils.BowShootUtils;
import me.sl4v.verysl4vicplugin.utils.GeneralUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class BowShootCommand implements CommandExecutor
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
            if (command.getName().equals("bowshoot"))
            {
                EntityType chosenEntity = EntityType.ARROW;
                try {
                    chosenEntity = EntityType.valueOf(args[0]);
                    if (!chosenEntity.isSpawnable())
                    {
                        GeneralUtils.showErrorToPlayer(
                                player,
                                BowShootUtils.InvalidEntityError
                        );
                        return true;
                    }
                } catch (Exception e)
                {
                    GeneralUtils.showErrorToPlayer(
                            player,
                            BowShootUtils.InvalidEntityError
                            );
                    return true;
                }
                BowShootUtils.setEntityTypeForPlayer(player.getDisplayName(), chosenEntity);
                player.sendMessage("Set bow shoot entity type to " + chosenEntity.name());
            } else if (command.getName().equals("entitylist"))
            {
                player.sendMessage(BowShootUtils.getEntityTypeMessage());
            }
        }
        return true;
    }
}
