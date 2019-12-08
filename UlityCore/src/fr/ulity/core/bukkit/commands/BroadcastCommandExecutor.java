package fr.ulity.core.bukkit.commands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.utils.allArgs;


public class BroadcastCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length != 0) 
    		Bukkit.broadcastMessage("§7" + allArgs.run(args).replaceAll("&", "§"));
    	else 
    		sender.sendMessage(lang.get("msg.empty_arg"));

    	return true;

   } 
}