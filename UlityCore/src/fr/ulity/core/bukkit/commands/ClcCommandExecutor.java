
package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.utils.AllArgs;


public class ClcCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	for(int i = 0; i < 100; i++)
    		MainBukkit.plugin.getServer().broadcastMessage("");
    	
    	String msg = Lang.get("msg.ChatClear");
    	
    	if (sender instanceof Player) 
    		msg = msg.replaceAll("%staff%", sender.getName()); 
    	else 
    		msg = msg.replaceAll("%staff%", Lang.get("console"));
    	
    	if (args.length == 0) 
    		msg = msg.replaceAll("%reason%", Lang.get("unknown_reason"));
    	else 
    		msg = msg.replaceAll("%reason%", AllArgs.run(args));
    	
    	MainBukkit.server.broadcastMessage(msg);

    	return true;

   } 
}