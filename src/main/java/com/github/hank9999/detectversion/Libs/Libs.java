package com.github.hank9999.detectversion.Libs;

import com.github.hank9999.detectversion.DetectVersion;
import org.bukkit.ChatColor;

public class Libs {
    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String replacePlaceholder(String text, String playerName, String playerVersion) {
        return color(text)
                .replaceAll("%playerName%", playerName)
                .replaceAll("%playerVersion%", playerVersion);
    }

    public static void commandExec(String command) {
        DetectVersion.ins.getServer().dispatchCommand(
                DetectVersion.ins.getServer().getConsoleSender(),
                command
        );
    }

}
