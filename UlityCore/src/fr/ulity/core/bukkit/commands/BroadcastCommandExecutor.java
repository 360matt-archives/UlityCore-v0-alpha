package fr.ulity.core.bukkit.commands;

import org.bukkit.Bukkit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import fr.ulity.core.bukkit.Lang;
import fr.ulity.core.utils.AllArgs;


public class BroadcastCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if (args.length != 0) 
    		Bukkit.broadcastMessage(Lang.get("global.server-prefix") + "§7" + AllArgs.run(args).replaceAll("&", "§"));
    	else 
    		sender.sendMessage(Lang.get("msg.empty_arg"));

    	return true;

   } 
}