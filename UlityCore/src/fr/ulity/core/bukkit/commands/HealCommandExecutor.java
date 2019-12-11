
package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.utils.Syntax;


public class HealCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (!(sender instanceof Player)) {
    		if (args.length != 1) 
    			sender.sendMessage(Syntax.run("heal", "player"));
    		else {
    			if (MainBukkit.server.getPlayer(args[0]) == null) 
    				sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			else {
    				Player playerTarget = MainBukkit.server.getPlayer(args[0]);
    				playerTarget.setFoodLevel(20);
    				playerTarget.setHealth(20);
    				playerTarget.sendMessage(Lang.get("heal.HealNotification"));
    				sender.sendMessage(Lang.get("heal.HealNotificationOther").replaceAll("%name%", args[0]));
    			}
    		}
    	}
    	else {
    		if (args.length != 1) {    			
    			((Player) sender).setFoodLevel(20);
    			sender.sendMessage(Lang.get("heal.HealNotification"));
    		}
    		else {
    			if (MainBukkit.server.getPlayer(args[0]) == null) 
    				sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			else {
    				Player playerTarget = MainBukkit.server.getPlayer(args[0]);
    				playerTarget.setFoodLevel(20);
    				playerTarget.setHealth(20);
    				playerTarget.sendMessage(Lang.get("heal.HealNotification"));
    				if (sender.getName() != playerTarget.getName())
    					sender.sendMessage(Lang.get("heal.HealNotificationOther").replaceAll("%name%", args[0]));
    			}
    		}
    	}
    	
    	
    	return true;

   } 
}