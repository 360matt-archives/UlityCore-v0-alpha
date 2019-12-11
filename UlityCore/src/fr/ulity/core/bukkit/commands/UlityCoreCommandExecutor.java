package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.bukkit.Temp;
import fr.ulity.core.bukkit.utils.Permissions;
import fr.ulity.core.bukkit.Config;
import fr.ulity.core.bukkit.Lang;

public class UlityCoreCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (args.length == 0) {
    		switch(Config.lang) {
				case "fr":
					sender.sendMessage("§bUlityCore §7est créé par §c360matt");
					sender.sendMessage("§7Version: §av" + MainBukkit.plugin.getDescription().getVersion());
					sender.sendMessage("§7Ce plugin est une librairie de fonctionnalités.");
					break;
				default:
					sender.sendMessage("§bUlityCore §7is created by §c360matt");
					sender.sendMessage("§7Version: §av" + MainBukkit.plugin.getDescription().getVersion());
					sender.sendMessage("§7This plugin is a fonctionnality's library.");

    		}
		}
   		else
   			switch(args[0]) {
				case "reload":
				case "rl":
    				if (Permissions.hasPrivileges_ShowError(sender)) {
    					MainBukkit.config.reload();
    					Lang.reload();
    					sender.sendMessage(Lang.get("msg.plugin_reloaded"));
    					
    					if (args.length >= 2) {
		        			if (args[1].equals("temp") || args[1].equals("tmp")) {
		                		Temp.reload();
		                		sender.sendMessage(Lang.get("msg.TempReloaded"));
		        			}
		        		}
    				}
    				break;
    				
   				case "lang":
   				case "langue":
   					if (args.length == 1)
   						sender.sendMessage(Lang.get("msg.actual_lang"));
   					else {
   						if (Permissions.hasPrivileges_ShowError(sender)) {
   							MainBukkit.config.set("lang", args[1]);
   							MainBukkit.config.reload();
	    					Lang.reload();
	    					sender.sendMessage(Lang.get("msg.lang_modified"));
	    				}
	    				else {
	    					sender.sendMessage(Lang.get("msg.not_opped"));
	    				}

   					}
   					break;
   				default:
   					sender.sendMessage(Lang.get("msg.invalid_arg").replaceAll("%arg%", args[0]));
   			}
    	
    	
	return true;
   } 
}