package io.github.flarereturns.bountifulevents.commands;

import io.github.flarereturns.bountifulevents.Main;
import io.github.flarereturns.bountifulevents.misc.Events;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BountifulEventsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player) {
            Player p = (Player) sender;
            if(args.length == 1) {
                if(args[0].equalsIgnoreCase("toggle")) {
                    if(p.hasPermission("bountifulevents.toggle")) {
                        if(!(Events.noBountiful.contains(p.getUniqueId()))) {
                            Events.noBountiful.add(p.getUniqueId());
                            p.sendMessage(Main.pr + Main.getCfg().disableMsg);
                            return true;
                        } else {
                            Events.noBountiful.remove(p.getUniqueId());
                            p.sendMessage(Main.pr + Main.getCfg().enableMsg);
                            return true;
                        }
                    } else {
                        p.sendMessage(Main.pr + Main.getCfg().noPerm.replaceAll("%PERM%", "bountifulevents.toggle"));
                        return true;
                    }
                }
                if(args[0].equalsIgnoreCase("reload")) {
                    if(p.hasPermission("bountifulevents.reload")) {
                        long ms = System.currentTimeMillis();
                        Main.getCfg().setupConfig();
                        // FIX THIS
                        long milis = System.currentTimeMillis() - ms;
                        p.sendMessage(Main.pr + Main.getCfg().reloadMsg.replaceAll("%MS%", milis + "ms"));
                        return true;
                    } else {
                        p.sendMessage(Main.pr + Main.getCfg().noPerm.replaceAll("%PERM%", "bountifulevents.reload"));
                        return true;
                    }
                }
            }
        } else {
            sender.sendMessage(Main.pr + "You must be a Player to execute this command.");
            return true;
        }
        return false;
    }

}
