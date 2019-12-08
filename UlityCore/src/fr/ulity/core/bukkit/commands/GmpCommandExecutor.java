package fr.ulity.core.bukkit.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.bukkit.utils.permissions;
import fr.ulity.core.utils.syntax;

public class GmpCommandExecutor implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if ((!(sender instanceof Player) && args.length != 1)) {
    		sender.sendMessage(syntax.run("gmp", "player"));
    		return true;
    	}
    	else {
    		Player playerTarget = null;
    		
    		if (args.length != 0) {
    			if (permissions.hasPrivileges_ShowError(sender)) {
    				return true;
    			}
            	if (mainBukkit.server.getPlayer(args[0]) == null) {
            		sender.sendMessage(lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
            		return true;
            	}
            	else {
            		playerTarget = mainBukkit.server.getPlayer(args[0]);
            	}
    		}
    		else 
    			playerTarget = (Player) sender;
    		
			playerTarget.setGameMode(GameMode.SPECTATOR);
			playerTarget.sendMessage(lang.get("gamemode.GamemodeNotification").replaceAll("%mod%", lang.get("gamemode.spectator")));
			
			if (sender.getName() != playerTarget.getName())
				sender.sendMessage(lang.get("gamemode.ChangeGamemodeOther").replaceAll("%mod%", lang.get("gamemode.spectator")).replaceAll("%name%", playerTarget.getName()));
   		
    	}
    	
    return true;
   
    } 
}