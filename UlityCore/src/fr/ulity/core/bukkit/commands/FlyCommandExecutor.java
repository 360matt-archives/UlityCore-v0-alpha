package fr.ulity.core.bukkit.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;

public class FlyCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	if (args.length != 1 && !(sender instanceof Player)) {
    		sender.sendMessage("§cSyntaxe correcte: §8/fly §c<§7Joueur§c>");
    	}
    		
    	else {
    			
    		Player playerTarget;
    		Boolean show = false;
    			
    		if (args.length == 0) 
    			playerTarget = (Player) sender;
    		else {
        		if (mainBukkit.server.getPlayer(args[0]) == null) {
        			sender.sendMessage(lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
        			return false;
        		}
        			
    			playerTarget = mainBukkit.plugin.getServer().getPlayer(args[0]);
    			show = true;
    		}
    			
    		if (!playerTarget.getAllowFlight()) {
    			playerTarget.setAllowFlight(true);
    			playerTarget.setFlying(true);
    				
    			playerTarget.sendMessage(lang.get("msg.FlyNotification").replaceAll("%stat%", "§a" + lang.get("enabled")));
    			if (show)
    				sender.sendMessage(lang.get("msg.ChangeFlyOther").replaceAll("%stat%", "§a" + lang.get("enabled")).replaceAll("%name%", playerTarget.getName()));
    		}
    		else {
    			if (!(playerTarget.getGameMode() == GameMode.CREATIVE))
    				playerTarget.setAllowFlight(false);
    			playerTarget.setFlying(false);
    				
    			playerTarget.sendMessage(lang.get("msg.FlyNotification").replaceAll("%stat%", "§c" + lang.get("disabled")));
    			if (show)
    				sender.sendMessage(lang.get("msg.ChangeFlyOther").replaceAll("%stat%", "§c" + lang.get("disabled")).replaceAll("%name%", playerTarget.getName()));
    		}
    		
    	}
    	
    	
	return true;
   } 
}