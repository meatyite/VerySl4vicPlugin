package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.utils.*;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.*;

import org.bukkit.ChatColor;


public class VerySl4vicEventHandler implements Listener
{
    // LightningStick event handler
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event)
    {
        LightningStickUtils utils = new LightningStickUtils(event);

        if (utils.isLightningStickEnabledForPlayer() && utils.isPlayerRightClickingBlock() && utils.isPlayerHoldingBlazingRod())
        {
            utils.lightningStrikeBlock();
        }
    }

    // BowShoot event handler
    @EventHandler
    public void onEntityBowShoot(EntityShootBowEvent event)
    {

        if (BowShootUtils.isEntityPlayer(event))
        {
            EntityType projectileType = BowShootUtils.getEntityTypeForPlayer(event.getEntity().getName());
            if (projectileType == EntityType.ARROW)
            {
                return;
            }
            Entity entity = event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), projectileType);
            event.setProjectile(entity);
        }
    }

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
        BowShootUtils.setEntityTypeForPlayer(playerDisplayName, EntityType.ARROW);
        LightningStickUtils.setLightningStickEnabledForPlayer(playerDisplayName, false);

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
