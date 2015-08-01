package io.github.flarereturns.bountifulevents;

import io.github.flarereturns.bountifulevents.commands.BountifulEventsCommand;
import io.github.flarereturns.bountifulevents.listeners.*;
import io.github.flarereturns.bountifulevents.misc.Configuration;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public static String pr = "§8[§7Bountiful§rEvents§8] ";
    private static Main instance;
    private static Configuration cfg;

    @Override
    public void onEnable() {
        instance = this;
        cfg = new Configuration();
        checkDepend();
        getCfg().setupConfig();
        registerListeners();
        registerCommands();
        Bukkit.getConsoleSender().sendMessage("[BountifulEvents] BountifulEvents v" + getDescription().getVersion() + " enabled.");
    }

    @Override
    public void onDisable() {
        cfg = null;
        instance = null;
        Bukkit.getConsoleSender().sendMessage("[BountifulEvents] BountifulEvents v" + getDescription().getVersion() + " disabled.");
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new Quit(), this);
        pm.registerEvents(new Death(), this);
        pm.registerEvents(new Place(), this);
        pm.registerEvents(new Break(), this);
        pm.registerEvents(new Achievment(), this);
        pm.registerEvents(new Fish(), this);
    }

    private void registerCommands() {
        Bukkit.getPluginCommand("bountifulevents").setExecutor(new BountifulEventsCommand());
    }

    private void checkDepend() {
        if(!(Bukkit.getPluginManager().isPluginEnabled("BountifulAPI"))) {
            System.err.println("[BountifulEvents] BountifulAPI is not installed.");
            System.err.println("[BountifulEvents] Download it and try again.");
            Bukkit.getPluginManager().disablePlugin(this);
        } else {
            System.out.println("[BountifulEvents] BountifulAPI found.");
        }
    }

    public static Main getInstance() {
        return instance;
    }

    public static Configuration getCfg() {
        return cfg;
    }
}
