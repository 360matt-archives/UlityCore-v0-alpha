package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.utils.IndexUtils;

public class KickCommandExecutor implements CommandExecutor{
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length == 0) 
    		sender.sendMessage(Lang.get("kick.no_arg"));
    	else {
    		
    		Player target = MainBukkit.server.getPlayer(args[0]);
    			
    		if (target == null) {
    			sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			return true;
    		}
    		
    		String reason;
    		
    		if (args.length == 1) 
    			reason = Lang.get("kick.default_msg");
    		else 
    			reason = "§7" + IndexUtils.allArgs(args, 1);
    		
    		target.kickPlayer(reason);
    		
    	}
    	
    	return true;
    }
}
