package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.utils.LandMineUtils;
import me.sl4v.verysl4vicplugin.utils.NameColorUtils;
import me.sl4v.verysl4vicplugin.utils.PlayerHeadUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;


public class VerySl4vicEventHandler implements Listener
{
    // Beheading event handler
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event)
    {
        event.getDrops().add(PlayerHeadUtils.getPlayerHead(event.getEntity()));
    }

    // NameColor event handler
    @EventHandler
    public void chatFormat(AsyncPlayerChatEvent event)
    {
        NameColorUtils.setMessageFormat(event);
    }

    // LandMine event handler
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event)
    {
        LandMineUtils utils = new LandMineUtils(event);

        if (utils.isPlayerWalkingOnLandMine() && !utils.isPlayerStanding())
        {
            utils.ExplodePlayer();
        }
    }

    // Join / Quit Message events
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event)
    {
        Player player = event.getPlayer();
        event.setQuitMessage(
                ChatColor.RED
                        + player.getName()
                        + ChatColor.GREEN
                        + " Has "
                        + ChatColor.RED
                        +  "ragequitted"
                        + ChatColor.GREEN
                        + "."

        );
    }

    @EventHandler
    public void onPlayerJoined(PlayerJoinEvent event)
    {
        Player player = event.getPlayer();

        String playerDisplayName = player.getDisplayName();
        NameColorUtils.name_colors.put(playerDisplayName, ChatColor.WHITE);

        String private_msg = ChatColor.YELLOW
                + "Welcome to our server, "
                + ChatColor.RED
                + playerDisplayName
                + ChatColor.YELLOW
                + "!";

        player.sendMessage(private_msg);

        String public_msg = ChatColor.RED
                + playerDisplayName
                + ChatColor.YELLOW
                + " Has joined the server.";

        event.setJoinMessage(public_msg);
    }
}
