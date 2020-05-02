package com.github.prypurity.xiaviccore.Commands.UserCmds.Fun;

import com.github.prypurity.xiaviccore.Utils.Utils;
import com.github.prypurity.xiaviccore.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

// TODO: Refactor Required

public class NearCommand implements CommandExecutor {

    private double radius = Main.mainConfig.getDouble("NearRadius");

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission("Near") || player.isOp()) {
                boolean found = false;
                ArrayList<String> nearbyPlayers = new ArrayList<>();
                for (Player target : Bukkit.getOnlinePlayers()) {
                    double distance = player.getLocation().distance(target.getLocation());
                    if (distance <= radius) {
                        found = true;
                        nearbyPlayers.add("    " + target.getName() + ": " + distance + "m");
                    }
                }
                if (found) {
                    player.sendMessage(Utils.chat("List of nearby players:"));
                    for (String s : nearbyPlayers) {
                        player.sendMessage(Utils.chat(s));
                    }
                } else {
                    player.sendMessage("No players are nearby!");
                }
                return true;
            } else {
                player.sendMessage(Utils.chat(Main.messages.getString("NoPerms")));
            }
            return true;
        } else {
            sender.sendMessage(Utils.chat(Main.messages.getString("SenderNotPlayer")));
        }
        return false;
    }
}
