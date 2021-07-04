package com.github.hank9999.detectversion.Libs;

import com.github.hank9999.detectversion.DetectVersion;

import java.util.List;

public class Config {

    public static List<String> RecommendedVersion;
    public static Long delay;
    public static Boolean DetectWhenJoin;
    public static String VersionNotMatchFunction;
    public static List<String> Commands;
    public static List<String> Messages;

    public static void loadConfig() {
        DetectVersion.ins.saveDefaultConfig();
        DetectVersion.ins.reloadConfig();

        setValue();
    }

    public static void reloadConfig() {
        DetectVersion.ins.saveDefaultConfig();
        DetectVersion.ins.reloadConfig();

        setValue();
    }

    public static void setValue() {
        RecommendedVersion = DetectVersion.ins.getConfig().getStringList("RecommendedVersion");
        delay = DetectVersion.ins.getConfig().getLong("delay");
        DetectWhenJoin = DetectVersion.ins.getConfig().getBoolean("DetectWhenJoin");
        VersionNotMatchFunction = DetectVersion.ins.getConfig().getString("VersionNotMatchFunction");
        Commands = DetectVersion.ins.getConfig().getStringList("Commands");
        Messages = DetectVersion.ins.getConfig().getStringList("Messages");

        if (delay == null) {
            delay = 50L;
        }
    }

}
