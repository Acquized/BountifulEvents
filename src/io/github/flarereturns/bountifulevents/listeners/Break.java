package io.github.flarereturns.bountifulevents.listeners;

import com.connorlinfoot.bountifulapi.BountifulAPI;
import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Break implements Listener {

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        for(Player o : Bukkit.getOnlinePlayers()) {
            if(!(Events.noBountiful.contains(o.getUniqueId()))) {
                BountifulAPI.sendTitle(o, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                        Main.getCfg().breakTitleGlobal.replaceAll("%PLAYER%", p.getName().replaceAll("%BLOCK%", e.getBlock().getType().name())), Main.getCfg().breakSubtitleGlobal.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
                BountifulAPI.sendActionBar(p, Main.getCfg().breakActionbarGlobal.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
            }
        }
        if(!(Events.noBountiful.contains(p.getUniqueId()))) {
            BountifulAPI.sendTitle(p, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut,
                    Main.getCfg().breakTitleOwn.replaceAll("%PLAYER%", p.getName().replaceAll("%BLOCK%", e.getBlock().getType().name())), Main.getCfg().breakSubtitleOwn.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
            BountifulAPI.sendActionBar(p, Main.getCfg().breakActionbarOwn.replaceAll("%PLAYER%", p.getName()).replaceAll("%BLOCK%", e.getBlock().getType().name()));
        }
    }

}
