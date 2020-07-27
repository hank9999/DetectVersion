package com.github.hank9999.detectversion;

import com.github.hank9999.detectversion.Commands.ReloadCommand;
import com.github.hank9999.detectversion.Libs.Config;
import com.github.hank9999.detectversion.Commands.MainCommand;
import com.github.hank9999.detectversion.Listener.JoinListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class DetectVersion extends JavaPlugin {

    public static DetectVersion ins;

    @Override
    public void onEnable() {
        ins = this;

        Config.loadConfig();

        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);

        Objects.requireNonNull(getServer().getPluginCommand("getversion")).setExecutor(new MainCommand());
        Objects.requireNonNull(getServer().getPluginCommand("getversion")).setTabCompleter(new MainCommand());
        Objects.requireNonNull(getServer().getPluginCommand("detectversion-reload")).setExecutor(new ReloadCommand());

        getLogger().info(ChatColor.BLUE + "DetectVersion Enable");
        getLogger().info(ChatColor.BLUE + "Version: " + ChatColor.AQUA + getDescription().getVersion());
    }

    @Override
    public void onDisable() {
        ins = null;

        getLogger().info(ChatColor.BLUE + "DetectVersion Disable");
    }
}
