package fr.ulity.core.bukkit.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.bukkit.utils.Permissions;
import fr.ulity.core.utils.Syntax;

public class GmaCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if ((!(sender instanceof Player) && args.length != 1)) {
    		sender.sendMessage(Syntax.run("gma", "player"));
    		return true;
    	}
    	else {
    		Player playerTarget = null;
    		
    		if (args.length != 0) {
    			if (!Permissions.hasPrivileges(sender) 
    			&& !sender.hasPermission("ulity.gamemode.other") 
    			&& !sender.hasPermission("ulity.gm.other")
    			&& !sender.hasPermission("ulity.gma.other")) {
    				sender.sendMessage(Lang.get("gamemode.no_perm_other"));
    				return true;
    			}
            	if (MainBukkit.server.getPlayer(args[0]) == null) {
            		sender.sendMessage(Lang.get("msg.InvalidPlayer")
            						.replaceAll("%name%", args[0]));
            		return true;
            	}
            	else 
            		playerTarget = MainBukkit.server.getPlayer(args[0]);
    		}
    		else 
    			playerTarget = (Player) sender;
    		
			playerTarget.setGameMode(GameMode.ADVENTURE);
			playerTarget.sendMessage(Lang.get("gamemode.GamemodeNotification")
									.replaceAll("%mod%", Lang.get("gamemode.adventure")));
			
			if (sender.getName() != playerTarget.getName())
				sender.sendMessage(Lang.get("gamemode.ChangeGamemodeOther")
									.replaceAll("%mod%", Lang.get("gamemode.adventure"))
									.replaceAll("%name%", playerTarget.getName()));
   		
    	}
    	
    return true;
   
    } 
}