package fr.ulity.core.bukkit.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.utils.syntax;

public class GamemodeCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	Player playerTarget = null;
		String mod = null;
    	
    	if ((!(sender instanceof Player) && args.length != 2) || args.length == 0) {
    		sender.sendMessage(syntax.run(cmd.getName(), "player", "mod"));
    		return true;
    	}
    	else {
    		if (args.length == 2) {  			
    			if ((mainBukkit.server.getPlayer(args[0]) == null) && (mainBukkit.server.getPlayer(args[1]) == null)) {
    				sender.sendMessage(lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    				return true;
    			}
    			if (mainBukkit.server.getPlayer(args[0]) != null) {
        			playerTarget = mainBukkit.server.getPlayer(args[0]);
        			mod = args[1];
    			}
    			else {
        			playerTarget = mainBukkit.server.getPlayer(args[1]);
        			mod = args[0];
    			}
    		}
    		else {
    			playerTarget = (Player) sender;
    			mod = args[0];
    		}
    	}

    	
    	switch (mod) {
			case "creative":
			case "creatif":
			case "1":
			case "crea":
				playerTarget.setGameMode(GameMode.CREATIVE);
				playerTarget.sendMessage(lang.get("gamemode.GamemodeNotification").replaceAll("%mod%", lang.get("gamemode.creative")));
				if (sender.getName() != playerTarget.getName())
					sender.sendMessage(lang.get("gamemode.ChangeGamemodeOther").replaceAll("%mod%", lang.get("gamemode.creative")).replaceAll("%name%", playerTarget.getName()));
				break;
			case "survival":
			case "survie":
			case "0":
			case "surv":
				playerTarget.setGameMode(GameMode.SURVIVAL);
				playerTarget.sendMessage(lang.get("gamemode.GamemodeNotification").replaceAll("%mod%", lang.get("gamemode.survival")));
				if (sender.getName() != playerTarget.getName())
					sender.sendMessage(lang.get("gamemode.ChangeGamemodeOther").replaceAll("%mod%", lang.get("gamemode.survival")).replaceAll("%name%", playerTarget.getName()));
				break;
			case "adventure":
			case "aventure":
			case "2":
			case "av":
				playerTarget.setGameMode(GameMode.ADVENTURE);
				playerTarget.sendMessage(lang.get("gamemode.GamemodeNotification").replaceAll("%mod%", lang.get("gamemode.adventure")));
				if (sender.getName() != playerTarget.getName())
					sender.sendMessage(lang.get("gamemode.ChangeGamemodeOther").replaceAll("%mod%", lang.get("gamemode.adventure")).replaceAll("%name%", playerTarget.getName()));
    			break;
			case "spectator":
			case "spectateur":
			case "3":
			case "spect":
			case "spec":
			case "spe":
				playerTarget.setGameMode(GameMode.SPECTATOR);
				playerTarget.sendMessage(lang.get("GamemodeNotification").replaceAll("%mod%", lang.get("gamemode.spectator")));
				if (sender.getName() != playerTarget.getName())
					sender.sendMessage(lang.get("ChangeGamemodeOther").replaceAll("%mod%", lang.get("gamemode.spectator")).replaceAll("%name%", playerTarget.getName()));
    			break;
    		default:
    			sender.sendMessage(lang.get("gamemode.InvalidGamemode").replaceAll("%mod%", mod));

    	}
    	
    return true;
    
    }
   
}