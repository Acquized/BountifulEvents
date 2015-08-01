package io.github.flarereturns.bountifulevents.misc;

import io.github.flarereturns.bountifulevents.Main;
import org.bukkit.ChatColor;

import java.io.IOException;

public class Configuration {

    // MESSAGES
    public String enableMsg;
    public String disableMsg;
    public String reloadMsg;
    public String noPerm;

    // OPTIONS
    public int titleFadeIn;
    public int titleStay;
    public int titleFadeOut;

    // TITLE
    public String joinTitleOwn;
    public String joinTitleGlobal;

    public String quitTitleGlobal;

    public String deathTitleOwn;
    public String deathTitleGlobal;

    public String placeTitleOwn;
    public String placeTitleGlobal;

    public String breakTitleOwn;
    public String breakTitleGlobal;

    // SUBTITLE
    public String joinSubtitleOwn;
    public String joinSubtitleGlobal;

    public String quitSubtitleGlobal;

    public String deathSubtitleOwn;
    public String deathSubtitleGlobal;

    public String placeSubtitleOwn;
    public String placeSubtitleGlobal;

    public String breakSubtitleOwn;
    public String breakSubtitleGlobal;

    // ACTIONBAR
    public String joinActionbarOwn;
    public String joinActionbarGlobal;

    public String quitActionbarGlobal;

    public String deathActionbarOwn;
    public String deathActionbarGlobal;

    public String placeActionbarOwn;
    public String placeActionbarGlobal;

    public String breakActionbarOwn;
    public String breakActionbarGlobal;

    public void setupConfig() {
        // Load Config [HIGHEST PRIORITY]
        Main.getInstance().getConfig().options().copyDefaults(true);
        Main.getInstance().saveConfig();

        // Load Messages [HIGH PRIORITY]
        Main.pr = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Options.Messages.Prefix"));
        enableMsg = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Options.Messages.ToggleOn"));
        disableMsg = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Options.Messages.ToggleOff"));
        reloadMsg = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Options.Messages.Reload"));
        noPerm = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Options.Messages.NoPermission"));

        // Load Options [MONITOR PRIORITY]
        titleFadeIn = Main.getInstance().getConfig().getInt("Options.Title.FadeIn");
        titleStay = Main.getInstance().getConfig().getInt("Options.Title.Stay");
        titleFadeOut = Main.getInstance().getConfig().getInt("Options.Title.FadeOut");

        // Load Event Messages [LOW PRIORITY]
        joinTitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Own.Title"));
        joinTitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Global.Title"));
        joinSubtitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Own.Subtitle"));
        joinSubtitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Global.Subtitle"));
        joinActionbarOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Own.Actionbar"));
        joinActionbarGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerJoinEvent.Global.Actionbar"));
        quitTitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerQuitEvent.Global.Title"));
        quitSubtitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerQuitEvent.Global.Subtitle"));
        quitActionbarGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerQuitEvent.Global.Actionbar"));
        deathTitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Own.Title"));
        deathTitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Global.Title"));
        deathSubtitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Own.Subtitle"));
        deathSubtitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Global.Subtitle"));
        deathActionbarOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Own.Actionbar"));
        deathActionbarGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.PlayerDeathEvent.Global.Actionbar"));
        placeTitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Own.Title"));
        placeTitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Global.Title"));
        placeSubtitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Own.Subtitle"));
        placeSubtitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Global.Subtitle"));
        placeActionbarOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Own.Actionbar"));
        placeActionbarGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockPlaceEvent.Global.Actionbar"));
        breakTitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Own.Title"));
        breakTitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Global.Title"));
        breakSubtitleOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Own.Subtitle"));
        breakSubtitleGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Global.Subtitle"));
        breakActionbarOwn = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Own.Actionbar"));
        breakActionbarGlobal = ChatColor.translateAlternateColorCodes('&', Main.getInstance().getConfig().getString("Events.BlockBreakEvent.Global.Actionbar"));

        // Load Metrics [LOWEST PRIORITY]
        try {
            MetricsLite metrics = new MetricsLite(Main.getInstance());
            metrics.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
