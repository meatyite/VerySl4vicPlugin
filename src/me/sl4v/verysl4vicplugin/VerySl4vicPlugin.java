package me.sl4v.verysl4vicplugin;

import me.sl4v.verysl4vicplugin.commands.*;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;


public class VerySl4vicPlugin extends JavaPlugin
{
    @Override
    public void onEnable()
    {
        VerySl4vicTabCompleter tabCompleter = new VerySl4vicTabCompleter();
        getLogger().info("Very sl4vic plugin has been enabled.");
        getServer().getPluginManager().registerEvents(new VerySl4vicEventHandler(), this);
        getCommand("randtp").setExecutor(new RandomTeleportCommand());
        NameColorCommand nameColorCMD = new NameColorCommand();
        getCommand("namecolor").setExecutor(nameColorCMD);
        getCommand("namecolor").setTabCompleter(tabCompleter);
        getCommand("namecolorList").setExecutor(nameColorCMD);
        getCommand("playerhead").setExecutor(new PlayerHeadCommand());
        SpawnTreeCommand treeSpawnCommands = new SpawnTreeCommand();
        getCommand("treespawn").setExecutor(treeSpawnCommands);
        getCommand("treespawn").setTabCompleter(tabCompleter);
        getCommand("treetypes").setExecutor(treeSpawnCommands);
        BowShootCommand bowShootCommands = new BowShootCommand();
        getCommand("bowshoot").setExecutor(bowShootCommands);
        getCommand("bowshoot").setTabCompleter(tabCompleter);
        getCommand("entitylist").setExecutor(bowShootCommands);
        getCommand("lightningStickEnable").setExecutor(new LightningStrikeCommand());
    }

}
