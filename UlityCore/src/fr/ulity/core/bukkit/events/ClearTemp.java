package fr.ulity.core.bukkit.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.ulity.core.bukkit.Temp;

public class ClearTemp implements Listener {
	public void onJoin (PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Temp.deleteList("player." + player.getName());
	}
	public void onQuit (PlayerQuitEvent e) {
		Player player = e.getPlayer();
		Temp.deleteList("player." + player.getName());
	}
	
}
