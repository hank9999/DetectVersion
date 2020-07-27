package com.github.hank9999.detectversion.Commands;

import com.github.hank9999.detectversion.DetectVersion;
import com.github.hank9999.detectversion.Libs.Libs;
import com.github.hank9999.detectversion.Libs.PVersion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import us.myles.ViaVersion.api.Via;

import java.util.Collections;
import java.util.List;

public class MainCommand implements TabExecutor {
    @Override
    final public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("getversion") || command.getName().equalsIgnoreCase("gv")) {

            if (!commandSender.hasPermission("DetectVersion.admin")) {
                commandSender.sendMessage(Libs.color("&6[DetectVersion] &cYou do not have permission to use this command"));
            }

            if (strings.length == 0) {
                commandSender.sendMessage(Libs.color("&6[DetectVersion] &fUse &7/" + command.getName() + " <playerName> &rto get player's client version."));
                commandSender.sendMessage(Libs.color("&6[DetectVersion] &fUse &7/" + command.getName() + " * &rto get all player's client version."));
                return true;
            }

            String playerName = strings[0];

            if (playerName.equalsIgnoreCase("*")) {
                for (Player p : DetectVersion.ins.getServer().getOnlinePlayers()) {
                    if (p != null) {
                        String GV = PVersion.getGV(Via.getAPI().getPlayerVersion(p.getUniqueId()));
                        commandSender.sendMessage(Libs.color("&b" + p.getName() + "&9 Client Version is &6" + GV));
                    }
                }

            } else {
                Player p = DetectVersion.ins.getServer().getPlayer(playerName);

                if (p == null) {
                    commandSender.sendMessage(Libs.color("&b" + playerName + " &cis not online!"));
                    return false;
                }

                String GV = PVersion.getGV(Via.getAPI().getPlayerVersion(p.getUniqueId()));
                commandSender.sendMessage(Libs.color("&b" + playerName + "&9 Client Version is &6" + GV));
            }
        }
        return true;
    }

    final public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length <= 1) {
            return null;
        }
        return Collections.emptyList();
    }

}
