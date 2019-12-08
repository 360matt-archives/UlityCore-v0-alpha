package fr.ulity.core.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.ulity.core.bukkit.temp;

public class clearTemp implements Listener {
	public void onJoin (PlayerJoinEvent e) {
		Player player = e.getPlayer();
		temp.deleteList("player." + player.getName());
	}
	public void onQuit (PlayerQuitEvent e) {
		Player player = e.getPlayer();
		temp.deleteList("player." + player.getName());
	}
	
}
