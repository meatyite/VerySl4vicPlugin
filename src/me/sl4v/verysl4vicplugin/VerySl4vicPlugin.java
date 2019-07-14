package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.commands.*;
import org.bukkit.plugin.java.JavaPlugin;


public class VerySl4vicPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        getLogger().info("Very sl4vic plugin has been enabled.");
        getServer().getPluginManager().registerEvents(new VerySl4vicEventHandler(), this);
        getCommand("randtp").setExecutor(new RandomTeleportCommand());
        NameColorCommand nameColorCMD = new NameColorCommand();
        getCommand("namecolor").setExecutor(nameColorCMD);
        getCommand("namecolorList").setExecutor(nameColorCMD);
        getCommand("playerhead").setExecutor(new PlayerHeadCommand());
        SpawnTreeCommand treeSpawnCommands = new SpawnTreeCommand();
        getCommand("treespawn").setExecutor(treeSpawnCommands);
        getCommand("treetypes").setExecutor(treeSpawnCommands);
    }

}
