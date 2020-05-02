package com.github.prypurity.xiaviccore.Commands.UserCmds.Fun.Links;

import com.github.prypurity.xiaviccore.Utils.Utils;
import com.github.prypurity.xiaviccore.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TwitterCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (player.hasPermission(Main.permissions.getString("Twitter")) || player.isOp()) {
            player.sendMessage(Utils.chat(Main.messages.getString("Twitter")));
        } else {
            player.sendMessage(Utils.chat(Main.messages.getString("NoPerms")));
        }
        return false;
    }
}
