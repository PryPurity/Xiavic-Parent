package Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuit implements Listener {

    @EventHandler
    private void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        String name = p.getDisplayName();
        if (!(p.hasPlayedBefore())) {
            event.setJoinMessage(ChatColor.DARK_PURPLE + "Welcome to the development server." + ChatColor.GREEN + " \nOnly those with authorized access may use this server.!");
            p.sendMessage(ChatColor.GOLD + "Welcome " + p.getName());
            Location spawn = new Location(p.getWorld(), 548.0f, 97.0f, -438.0f);
            p.teleport(spawn);

        } else {
            event.setJoinMessage(ChatColor.GOLD + "+ " + name);
        }

    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        event.setQuitMessage(ChatColor.DARK_RED + "- " + p.getDisplayName());

    }
}
