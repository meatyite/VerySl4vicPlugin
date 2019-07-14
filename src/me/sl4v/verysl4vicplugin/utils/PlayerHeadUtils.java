package me.sl4v.verysl4vicplugin.utils;

import me.sl4v.verysl4vicplugin.utils.NameColorUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;

public class PlayerHeadUtils
{
    private static String generatePlayerSkullDisplayName(String playerName) {
        // Gives the player name in "Head of <player name>" a color
        return "Head of " + NameColorUtils.name_colors.get(playerName) + playerName;
    }

    public static ItemStack getPlayerHead(Player player)
    {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skull = (SkullMeta) item.getItemMeta();

        String skullNameAndLore = PlayerHeadUtils.generatePlayerSkullDisplayName(player.getDisplayName());

        skull.setDisplayName(skullNameAndLore);

        ArrayList<String> lore = new ArrayList<String>();
        lore.add(skullNameAndLore);
        skull.setLore(lore);

        skull.setOwningPlayer(player);
        item.setItemMeta(skull);

        return item;
    }
}

