
package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.utils.allArgs;
import fr.ulity.core.utils.syntax;
import fr.ulity.core.bukkit.mainBukkit;


public class healCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (!(sender instanceof Player)) {
    		if (args.length != 1) 
    			sender.sendMessage(syntax.run("heal", "player"));
    		else {
    			if (mainBukkit.server.getPlayer(args[0]) == null) 
    				sender.sendMessage(lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			else {
    				Player playerTarget = mainBukkit.server.getPlayer(args[0]);
    				playerTarget.setFoodLevel(20);
    				playerTarget.sendMessage(lang.get("food.FoodNotification"));
    				sender.sendMessage(lang.get("food.FoodNotificationOther").replaceAll("%name%", args[0]));
    			}
    		}
    	}
    	else {
    		if (args.length != 1) {    			
    			((Player) sender).setFoodLevel(20);
    			sender.sendMessage(lang.get("food.FoodNotification"));
    		}
    		else {
    			if (mainBukkit.server.getPlayer(args[0]) == null) 
    				sender.sendMessage(lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			else {
    				Player playerTarget = mainBukkit.server.getPlayer(args[0]);
    				playerTarget.setFoodLevel(20);
    				playerTarget.sendMessage(lang.get("food.FoodNotification"));
    				if (sender.getName() != playerTarget.getName())
    					sender.sendMessage(lang.get("food.FoodNotificationOther").replaceAll("%name%", args[0]));
    			}
    		}
    	}
    	
    	
    	return true;

   } 
}