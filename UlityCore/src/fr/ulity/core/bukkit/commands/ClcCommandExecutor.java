
package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.utils.allArgs;


public class ClcCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	for(int i = 0; i < 100; i++)
    		mainBukkit.plugin.getServer().broadcastMessage("");
    	
    	String msg = lang.get("msg.ChatClear");
    	
    	if (sender instanceof Player) 
    		msg = msg.replaceAll("%staff%", sender.getName()); 
    	else 
    		msg = msg.replaceAll("%staff%", lang.get("console"));
    	
    	if (args.length == 0) 
    		msg = msg.replaceAll("%reason%", lang.get("unknown_reason"));
    	else 
    		msg = msg.replaceAll("%reason%", allArgs.run(args));
    	
    	mainBukkit.server.broadcastMessage(msg);

    	return true;

   } 
}