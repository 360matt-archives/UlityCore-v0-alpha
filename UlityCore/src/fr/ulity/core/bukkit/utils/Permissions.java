package fr.ulity.core.bukkit.utils;

import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.Lang;

public class Permissions {

	public static boolean hasPrivileges (CommandSender player) {
		if (player.isOp() || player.hasPermission("admin") || player.hasPermission("dev"))
			return true;
		else
			return false;
	}
	
	
	public static boolean hasPrivileges_ShowError (CommandSender player) {
		if (!hasPrivileges(player)) {
			player.sendMessage(Lang.get("not_opped"));
			return false;
		}
		else 
			return true;
	}
	
	
	
}
