package io.github.flarereturns.bountifulevents.listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class Death implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        for(Player o : Bukkit.getOnlinePlayers()) {
            if(!(Events.noBountiful.contains(o.getUniqueId()))) {
                BountifulAPI.sendTitle(o, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                        Main.getCfg().deathTitleGlobal.replaceAll("%PLAYER%", p.getName()), Main.getCfg().deathSubtitleGlobal.replaceAll("%PLAYER%", p.getName()));
                BountifulAPI.sendActionBar(o, Main.getCfg().deathActionbarGlobal.replaceAll("%PLAYER%", p.getName()));
            }
        }
        if(!(Events.noBountiful.contains(p.getUniqueId()))) {
            BountifulAPI.sendTitle(p, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                    Main.getCfg().deathTitleOwn.replaceAll("%PLAYER%", p.getName()), Main.getCfg().deathSubtitleOwn.replaceAll("%PLAYER%", p.getName()));
            BountifulAPI.sendActionBar(p, Main.getCfg().deathActionbarOwn.replaceAll("%PLAYER%", p.getName()));
        }
    }

}
