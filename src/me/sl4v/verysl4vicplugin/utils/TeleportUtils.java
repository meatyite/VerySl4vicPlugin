package me.sl4v.verysl4vicplugin.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import java.util.HashSet;
import java.util.Random;


public class TeleportUtils
{
    //List of all the unsafe blocks
    private static HashSet<Material> bad_blocks = new HashSet<>();

    static
    {
        bad_blocks.add(Material.LAVA);
        bad_blocks.add(Material.FIRE);
        bad_blocks.add(Material.CACTUS);
        bad_blocks.add(Material.CAMPFIRE);
        bad_blocks.add(Material.WATER); // We don't want the player spawning in the ocean
        bad_blocks.add(Material.BEDROCK);
    }

    private static Location generateLocation(Player player)
    {
        //Generate Random Location
        Random random = new Random();
        int min_xz = -29999984;
        int max_xz = 29999984;
        int x = random.nextInt(max_xz - min_xz) + min_xz; //The maximum world width and height is default
        int z = random.nextInt(max_xz - min_xz) + min_xz;
        int y = 150;

        Location randomLocation = new Location(player.getWorld(), x, y, z);
        y = randomLocation.getWorld().getHighestBlockYAt(randomLocation);
        randomLocation.setY(y);
        return randomLocation;
    }

    public static Location findSafeLocation(Player player)
    {
        Location randomLocation = generateLocation(player);
        while (!isLocationSafe(randomLocation)) {
            //Keep looking for a safe location
            randomLocation = generateLocation(player);
        }
        return randomLocation;

    }

    private static boolean isLocationSafe(Location location)
    {
        int x = location.getBlockX();
        int y = location.getBlockY();
        int z = location.getBlockZ();
        //Get instances of the blocks around where the player would spawn
        Block block = location.getWorld().getBlockAt(x, y, z);
        Block below = location.getWorld().getBlockAt(x, y - 1, z);
        Block above = location.getWorld().getBlockAt(x, y + 1, z);
        //Check to see if the surroundings are safe or not
        return !bad_blocks.contains(below.getType()) && below.getType().isSolid() && !above.getType().isSolid();
    }
}