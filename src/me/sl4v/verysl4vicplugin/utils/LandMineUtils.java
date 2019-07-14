package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerMoveEvent;

public class LandMineUtils
{
    private Block blockUnderneathPlayer;
    private PlayerMoveEvent playerEvent;
    public Player player;

    public LandMineUtils(PlayerMoveEvent playerEvent)
    {
        this.playerEvent = playerEvent;
        this.player = playerEvent.getPlayer();
    }

    public boolean isPlayerStanding()
    {
        Location from = this.playerEvent.getFrom();
        Location to = this.playerEvent.getTo();
        return from.getBlockX() == to.getBlockX() && from.getBlockY() == to.getBlockY() && from.getBlockZ() == from.getBlockZ();
    }

    private Block getBlockUnderneathPlayer()
    {
        return this.player.getWorld().getBlockAt(this.playerEvent.getFrom()).getRelative(0, -2, 0);
    }

    public boolean isPlayerWalkingOnLandMine()
    {
        this.blockUnderneathPlayer = this.getBlockUnderneathPlayer();
        return this.blockUnderneathPlayer.getType().equals(Material.TNT);

    }

    public void ExplodePlayer()
    {
        Location location = player.getLocation();
        // 2 Is for the force of the explosion
        // The first false is whether or not the explosion should set blocks on fire
        // The second false is wheter or not the explosion would break blocks
        player.getWorld().createExplosion(location.getX(), location.getY(), location.getZ(), 2, false, false);
        this.blockUnderneathPlayer.setType(Material.AIR);
    }
}
