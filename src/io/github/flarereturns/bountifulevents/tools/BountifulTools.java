package io.github.flarereturns.bountifulevents.tools;

import io.github.flarereturns.bountifulevents.Main;
import org.bukkit.entity.Player;

public class BountifulTools {

    public static void sendTitle(Player p, String title, String subTitle) {
        title(p, Main.getCfg().titleFadeIn, Main.getCfg().titleStay, Main.getCfg().titleFadeOut, title, subTitle);
    }

    public static void sendActionbar(Player p, String actionBar) {
        actionbar(p, actionBar);
    }

    private static void title(Player p, Integer fadeIn, Integer stayThere, Integer fadeOut, String title, String subTitle) {
        // not to be abused. xD
    }

    private static void actionbar(Player p, String actionBar) {

    }

}
