package fr.ulity.core.bukkit.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.base.Joiner;

import fr.ulity.core.bukkit.mainBukkit;


public class UlityCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	if (args.length == 0) {
        	List<String> _author = mainBukkit.plugin.getDescription().getAuthors();
        	String authors = Joiner.on("§7, §a").join(_author); 

    		sender.sendMessage("§b" + mainBukkit.plugin.getDescription().getName() + " §7est notre propre plugin créé en §cJava");
    		sender.sendMessage("§cVersion§7: v" + mainBukkit.plugin.getDescription().getVersion());
    		sender.sendMessage("§cAuteurs§7: §a" + authors);
    	}

    	return true;
    }
    
}