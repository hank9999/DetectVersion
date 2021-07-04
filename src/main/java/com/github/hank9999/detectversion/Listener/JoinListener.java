package com.github.hank9999.detectversion.Listener;

import com.github.hank9999.detectversion.Libs.Config;
import com.github.hank9999.detectversion.DetectVersion;
import com.github.hank9999.detectversion.Libs.Libs;
import com.github.hank9999.detectversion.Libs.PVersion;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;
import com.viaversion.viaversion.api.Via;

public class JoinListener implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        String GV = PVersion.getGV(Via.getAPI().getPlayerVersion(p.getUniqueId()));
        DetectVersion.ins.getServer().broadcast(ChatColor.AQUA + p.getName() + ChatColor.YELLOW + " Joined Server" + ChatColor.WHITE + "," + ChatColor.GREEN + " Client Version: " + ChatColor.DARK_AQUA + GV, "MiaoChatTransformation.broadcast");
        DetectVersion.ins.getServer().getLogger().info(ChatColor.AQUA + p.getName() + ChatColor.YELLOW + " Joined Server" + ChatColor.WHITE + "," + ChatColor.GREEN + " Client Version: " + ChatColor.DARK_AQUA + GV);
        boolean isRecommended = false;
        for (String v : Config.RecommendedVersion) {
            if (v.contains(GV)) {
                isRecommended = true;
                break;
            }
        }
        if (!isRecommended) {
            if (Config.VersionNotMatchFunction.equalsIgnoreCase("Messages")) {
                (new BukkitRunnable() {
                    public void run() {
                        for (String message : Config.Messages) {
                            p.sendMessage(Libs.replacePlaceholder(
                                    message,
                                    p.getName(),
                                    GV
                            ));
                        }
                    }
                }).runTaskLater(DetectVersion.ins, Config.delay);
            }
            if (Config.VersionNotMatchFunction.equalsIgnoreCase("Commands")) {
                (new BukkitRunnable() {
                    public void run() {
                        for (String Command : Config.Commands) {
                            Libs.commandExec(
                                    Libs.replacePlaceholder(
                                            Command,
                                            p.getName(),
                                            GV
                                    )
                            );
                        }
                    }
                }).runTaskLater(DetectVersion.ins, Config.delay);
            }
        }
    }
}
