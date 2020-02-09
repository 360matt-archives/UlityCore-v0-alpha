package fr.ulity.core.bukkit.events;

import org.bukkit.Bukkit;

import java.util.Date;

import org.bukkit.BanEntry;
import org.bukkit.BanList.Type;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.utils.Time;

public class Banned implements Listener {
	@EventHandler
	public void onJoin (PlayerLoginEvent e) {
		Player player = e.getPlayer();
		
		if (player.isBanned()) {
			
			BanEntry banInfo = Bukkit.getBanList(Type.NAME).getBanEntry(player.getName());
			
			String cooldown;
			Date expire = banInfo.getExpiration();
			
			if (expire == null)
				cooldown = Lang.get("expressions.permanent");
			else
				cooldown = Time.toLetters(expire.getTime() - new Date().getTime());
			
			
			e.disallow(PlayerLoginEvent.Result.KICK_BANNED, Lang.get("ban.ban_notification")
			.replaceAll("%staff%", banInfo.getSource().contentEquals("Server") ? "Console" : banInfo.getSource())
			.replaceAll("%reason%", banInfo.getReason() + "")
			.replaceAll("%time%", cooldown));

		}
	}
}
