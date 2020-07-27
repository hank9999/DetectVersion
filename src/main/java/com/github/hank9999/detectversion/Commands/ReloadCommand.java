package com.github.hank9999.detectversion.Commands;

import com.github.hank9999.detectversion.Libs.Config;
import com.github.hank9999.detectversion.Libs.Libs;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    @Override
    final public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("dv-reload") || command.getName().equalsIgnoreCase("detectversion-reload")) {
            if (!commandSender.hasPermission("DetectVersion.admin")) {
                commandSender.sendMessage(Libs.color("&6[DetectVersion] &cYou do not have permission to use this command"));
                return false;
            }

            Config.reloadConfig();

            commandSender.sendMessage(Libs.color("&6[DetectVersion] &b Reloaded Successfully"));
        }
        return true;
    }
}
