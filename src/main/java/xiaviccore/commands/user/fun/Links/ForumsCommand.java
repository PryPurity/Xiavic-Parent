package xiaviccore.commands.user.fun.Links;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xiaviccore.utils.Utils;

import static xiaviccore.XiavicCore.messages;
import static xiaviccore.XiavicCore.permissions;

public class ForumsCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;
        if (player.hasPermission(permissions.getString("Forums")) || player.isOp()) {
            player.sendMessage(Utils.chat(messages.getString("Forums")));
        } else {
            player.sendMessage(Utils.chat(messages.getString("NoPerms")));
        }
        return false;
    }
}
