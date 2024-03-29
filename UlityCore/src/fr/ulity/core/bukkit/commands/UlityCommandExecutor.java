package fr.ulity.core.bukkit.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.common.base.Joiner;

import fr.ulity.core.bukkit.MainBukkit;


public class UlityCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

    	if (args.length == 0) {
        	List<String> _author = MainBukkit.plugin.getDescription().getAuthors();
        	String authors = Joiner.on("�7, �a").join(_author); 

    		sender.sendMessage("�b" + MainBukkit.plugin.getDescription().getName() + " �7est notre propre plugin cr�� en �cJava");
    		sender.sendMessage("�cVersion�7: v" + MainBukkit.plugin.getDescription().getVersion());
    		sender.sendMessage("�cAuteurs�7: �a" + authors);
    	}

    	return true;
    }
    
}