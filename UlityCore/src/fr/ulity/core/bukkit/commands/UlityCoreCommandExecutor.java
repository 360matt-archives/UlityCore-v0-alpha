package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.bukkit.temp;
import fr.ulity.core.bukkit.utils.permissions;
import fr.ulity.core.bukkit.config;
import fr.ulity.core.bukkit.lang;

public class ulityCoreCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (args.length == 0) {
    		switch(config.lang) {
				case "fr":
					sender.sendMessage("§bUlityCore §7est créé par §c360matt");
					sender.sendMessage("§7Version: §av" + mainBukkit.plugin.getDescription().getVersion());
					sender.sendMessage("§7Ce plugin est une librairie de fonctionnalités.");
					break;
				default:
					sender.sendMessage("§bUlityCore §7is created by §c360matt");
					sender.sendMessage("§7Version: §av" + mainBukkit.plugin.getDescription().getVersion());
					sender.sendMessage("§7This plugin is a fonctionnality's library.");

    		}
		}
   		else
   			switch(args[0]) {
				case "reload":
				case "rl":
    				if (permissions.hasPrivileges_ShowError(sender)) {
    					config.reload();
    					lang.reload();
    					sender.sendMessage(lang.get("msg.plugin_reloaded"));
    					
    					if (args.length >= 2) {
		        			if (args[1].equals("temp") || args[1].equals("tmp")) {
		                		temp.reload();
		                		sender.sendMessage(lang.get("msg.TempReloaded"));
		        			}
		        		}
    				}
    				break;
    				
   				case "lang":
   				case "langue":
   					if (args.length == 1)
   						sender.sendMessage(lang.get("msg.actual_lang"));
   					else {
   						if (permissions.hasPrivileges_ShowError(sender)) {
	    					config.set("lang", args[1]);
	    					config.reload();
	    					lang.reload();
	    					sender.sendMessage(lang.get("msg.lang_modified"));
	    				}
	    				else {
	    					sender.sendMessage(lang.get("msg.not_opped"));
	    				}

   					}
   					break;
   				default:
   					sender.sendMessage(lang.get("msg.invalid_arg").replaceAll("%arg%", args[0]));
   			}
    	
    	
	return true;
   } 
}