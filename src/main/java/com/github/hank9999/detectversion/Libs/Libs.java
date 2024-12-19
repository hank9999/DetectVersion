package com.github.hank9999.detectversion.Libs;

import com.github.hank9999.detectversion.DetectVersion;
import org.bukkit.ChatColor;

import java.util.List;

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

    public static String GVsToString(List<String> GVs) {
        StringBuilder sb = new StringBuilder();

        if (GVs == null || GVs.isEmpty()) {
            sb.append("Unknown");
        } else if (GVs.size() == 1) {
            sb.append(GVs.get(0));
        } else {
            sb.append("[");
            sb.append(String.join(", ", GVs));
            sb.append("]");
        }

        return sb.toString();
    }

}
