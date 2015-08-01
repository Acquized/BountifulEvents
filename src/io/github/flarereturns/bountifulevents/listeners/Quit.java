package io.github.flarereturns.bountifulevents.listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Quit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        for(Player o : Bukkit.getOnlinePlayers()) {
            if(!(Events.noBountiful.contains(o.getUniqueId()))) {
                BountifulAPI.sendTitle(o, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                        Main.getCfg().quitTitleGlobal.replaceAll("%PLAYER%", p.getName()), Main.getCfg().quitSubtitleGlobal.replaceAll("%PLAYER%", p.getName()));
                BountifulAPI.sendActionBar(o, Main.getCfg().quitActionbarGlobal.replaceAll("%PLAYER%", p.getName()));
            }
        }
    }

}
