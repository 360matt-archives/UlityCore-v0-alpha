package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.temp;


public class ProtectCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player == false) {
    		sender.sendMessage(lang.get("msg.InGameOnly"));
    	}
    	else {
    		Player player = (Player)sender;
    		String name = player.getName();
    		
    		if (temp.isSet("player." + name + ".WorldProtect")) {
    			temp.delete("player." + name + ".WorldProtect");
    			player.sendMessage(lang.get("msg.ProtectCommand").replaceAll("%stat%", "§c" + lang.get("expressions.disabled")));
    		}
    		else {
    			temp.set("player." + name + ".WorldProtect", true);
    			player.sendMessage(lang.get("msg.ProtectCommand").replaceAll("%stat%", "§a" + lang.get("expressions.enabled")));
    		}

    	}
    	
    	
	return true;
   } 
}