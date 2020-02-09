package fr.ulity.core.bukkit.commands;

import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.Lang;

public class UnbanCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length == 0) 
    		sender.sendMessage(Lang.get("ban.no_arg"));
    	else {    		
    		Bukkit.getBanList(Type.NAME).pardon(args[0]);
    		
    		sender.sendMessage(Lang.get("ban.unban_result")
    		.replaceAll("%player%", args[0]));
    	}
    	
    	
    	return true;
    }
    
    
}