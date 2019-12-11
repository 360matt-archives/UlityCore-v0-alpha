package fr.ulity.core.bukkit.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;

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
        		if (MainBukkit.server.getPlayer(args[0]) == null) {
        			sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
        			return false;
        		}
        			
    			playerTarget = MainBukkit.plugin.getServer().getPlayer(args[0]);
    			show = true;
    		}
    			
    		if (!playerTarget.getAllowFlight()) {
    			playerTarget.setAllowFlight(true);
    			playerTarget.setFlying(true);
    				
    			playerTarget.sendMessage(Lang.get("msg.FlyNotification").replaceAll("%stat%", "§a" + Lang.get("enabled")));
    			if (show)
    				sender.sendMessage(Lang.get("msg.ChangeFlyOther").replaceAll("%stat%", "§a" + Lang.get("enabled")).replaceAll("%name%", playerTarget.getName()));
    		}
    		else {
    			if (!(playerTarget.getGameMode() == GameMode.CREATIVE))
    				playerTarget.setAllowFlight(false);
    			playerTarget.setFlying(false);
    				
    			playerTarget.sendMessage(Lang.get("msg.FlyNotification").replaceAll("%stat%", "§c" + Lang.get("disabled")));
    			if (show)
    				sender.sendMessage(Lang.get("msg.ChangeFlyOther").replaceAll("%stat%", "§c" + Lang.get("disabled")).replaceAll("%name%", playerTarget.getName()));
    		}
    		
    	}
    	
    	
	return true;
   } 
}