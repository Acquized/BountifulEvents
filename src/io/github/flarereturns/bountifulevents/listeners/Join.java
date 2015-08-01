package io.github.flarereturns.bountifulevents.listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        for(Player o : Bukkit.getOnlinePlayers()) {
            if(!(Events.noBountiful.contains(o.getUniqueId()))) {
                BountifulAPI.sendTitle(o, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                        Main.getCfg().joinTitleGlobal.replaceAll("%PLAYER%", p.getName()), Main.getCfg().joinSubtitleGlobal.replaceAll("%PLAYER%", p.getName()));
                BountifulAPI.sendActionBar(p, Main.getCfg().joinActionbarGlobal.replaceAll("%PLAYER%", p.getName()));
            }
        }
        if(!(Events.noBountiful.contains(p.getUniqueId()))) {
            BountifulAPI.sendTitle(p, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                    Main.getCfg().joinTitleOwn.replaceAll("%PLAYER%", p.getName()), Main.getCfg().joinSubtitleOwn.replaceAll("%PLAYER%", p.getName()));
            BountifulAPI.sendActionBar(p, Main.getCfg().joinActionbarOwn.replaceAll("%PLAYER%", p.getName()));
        }
    }

}
