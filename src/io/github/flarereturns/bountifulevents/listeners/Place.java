package io.github.flarereturns.bountifulevents.listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Place implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        for(Player o : Bukkit.getOnlinePlayers()) {
            if(!(Events.noBountiful.contains(o.getUniqueId()))) {
                BountifulAPI.sendTitle(o, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                        Main.getCfg().placeTitleGlobal.replaceAll("%PLAYER%", p.getName().replaceAll("%BLOCK%", e.getBlock().getType().name())), Main.getCfg().placeSubtitleGlobal.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
                BountifulAPI.sendActionBar(p, Main.getCfg().placeActionbarGlobal.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
            }
        }
        if(!(Events.noBountiful.contains(p.getUniqueId()))) {
            BountifulAPI.sendTitle(p, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                    Main.getCfg().placeTitleOwn.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()), Main.getCfg().placeSubtitleOwn.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
            BountifulAPI.sendActionBar(p, Main.getCfg().placeActionbarOwn.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
        }
    }

}
