package fr.ulity.core.bukkit.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.Temp;


public class ProtectCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	if (sender instanceof Player == false) {
    		sender.sendMessage(Lang.get("msg.InGameOnly"));
    	}
    	else {
    		Player player = (Player)sender;
    		String name = player.getName();
    		
    		if (Temp.isSet("player." + name + ".WorldProtect")) {
    			Temp.delete("player." + name + ".WorldProtect");
    			player.sendMessage(Lang.get("msg.ProtectCommand").replaceAll("%stat%", "§c" + Lang.get("expressions.disabled")));
    		}
    		else {
    			Temp.set("player." + name + ".WorldProtect", true);
    			player.sendMessage(Lang.get("msg.ProtectCommand").replaceAll("%stat%", "§a" + Lang.get("expressions.enabled")));
    		}

    	}
    	
    	
	return true;
   } 
}