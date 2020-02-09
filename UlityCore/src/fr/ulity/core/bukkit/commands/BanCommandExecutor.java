package fr.ulity.core.bukkit.commands;

import org.bukkit.Bukkit;
import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.utils.IndexUtils;

public class BanCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length == 0) 
    		sender.sendMessage(Lang.get("ban.no_arg"));
    	else {
    		
    		Player target = MainBukkit.server.getPlayer(args[0]);
    			
    		if (target == null) {
    			sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%player%", args[0]));
    			return true;
    		}
    		
    		String reason;
    		
    		if (args.length == 1) 
    			reason = Lang.get("expressions.unknown");
    		else 
    			reason = IndexUtils.allArgs(args, 1);
    			

    		Bukkit.getBanList(Type.NAME).addBan(target.getName(), reason, null, sender.getName());
    		
    		target.kickPlayer(Lang.get("ban.ban_notification")
    		.replaceAll("%staff%", sender.getName())
    		.replaceAll("%reason%", reason)
    		.replaceAll("%time%", Lang.get("expressions.permanent"))
    		);
    		
    		
    		MainBukkit.server.broadcastMessage(Lang.get("ban.ban_broadcast")
    		.replaceAll("%player%", target.getName())
    		.replaceAll("%staff%", sender.getName()));

    		
    	}

    	
    	return true;
    }
    
}
