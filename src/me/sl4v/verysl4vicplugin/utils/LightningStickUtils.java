package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class LightningStickUtils
{
    public PlayerInteractEvent playerInteractEvent;

    public LightningStickUtils(PlayerInteractEvent playerInteractEvent)
    {
        this.playerInteractEvent = playerInteractEvent;
    }

    public Boolean isLightningStickEnabledForPlayer()
    {
        return LightningStickUtils.isLightningStickEnabled_Static(this.playerInteractEvent.getPlayer().getDisplayName());
    }

    public Boolean isPlayerRightClickingBlock()
    {
        return this.playerInteractEvent.getAction() == Action.RIGHT_CLICK_BLOCK;
    }

    public void lightningStrikeBlock()
    {
        Block block = this.playerInteractEvent.getClickedBlock();
        Location blockLocation = block.getLocation();
        block.getWorld().spawnEntity(blockLocation, EntityType.LIGHTNING);
    }

    public Boolean isPlayerHoldingBlazingRod()
    {
        return this.playerInteractEvent.getItem().getType() == Material.BLAZE_ROD;
    }

    public static void setLightningStickEnabledForPlayer(String playerName, boolean enabled)
    {
        LightningStickUtils.playerLightningStickEnabledMap.put(playerName, enabled);
    }


    public static Boolean isLightningStickEnabled_Static(String playerName)
    {
        return LightningStickUtils.playerLightningStickEnabledMap.get(playerName);
    }

    private static Map<String, Boolean> playerLightningStickEnabledMap = new HashMap<String, Boolean>();


}