package com.github.prypurity.xiaviccore.Commands.UserCmds.Fun;

import com.github.prypurity.xiaviccore.Main;
import com.github.prypurity.xiaviccore.Utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ArghCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.hasPermission(Main.permissions.getString("Argh")) || player.isOp()) {
                if (command.getName().equalsIgnoreCase("Argh")) {
                    Utils.chat(player, Main.messages.getString("Argh"));
                }
                return true;
            }
        }
        return false;
    }
}
