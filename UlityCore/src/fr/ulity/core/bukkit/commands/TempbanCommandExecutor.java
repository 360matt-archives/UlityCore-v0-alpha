package fr.ulity.core.bukkit.commands;

import org.bukkit.Bukkit;

import java.util.Date;

import org.bukkit.BanList.Type;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.utils.IndexUtils;
import fr.ulity.core.utils.Time;

public class TempbanCommandExecutor implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length == 0) 
    		sender.sendMessage(Lang.get("tempban.no_arg"));
    	else if (args.length < 2) 
    		sender.sendMessage(Lang.get("tempban.no_arg_time"));
    	else {
    		Player target = MainBukkit.server.getPlayer(args[0]);
    			
    		if (target == null) {
    			sender.sendMessage(Lang.get("msg.InvalidPlayer").replaceAll("%name%", args[0]));
    			return true;
    		}
    		
    		long duration = Time.toSeconds(args[1]);
    		
    		String reason;
    		
    		if (args.length <= 2) 
    			reason = Lang.get("expressions.unknown");
    		else 
    			reason = IndexUtils.allArgs(args, 2);
    		
    		Bukkit.getBanList(Type.NAME).addBan(target.getName(), reason, new Date(new Date().getTime() + duration*1000), sender.getName());
    		
    		target.kickPlayer(Lang.get("ban.ban_notification")
    	    .replaceAll("%staff%", sender.getName())
    	    .replaceAll("%reason%", reason)
    	    .replaceAll("%time%", Time.toLetters(duration))
    	    );
    	    		
    	    		
    	    MainBukkit.server.broadcastMessage(Lang.get("ban.ban_broadcast")
    	    .replaceAll("%player%", target.getName())
    	    .replaceAll("%staff%", sender.getName()));
    		
    	}
    	
    	
    	return true;
    }
}
