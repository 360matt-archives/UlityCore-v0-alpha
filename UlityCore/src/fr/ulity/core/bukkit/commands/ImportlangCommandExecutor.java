package fr.ulity.core.bukkit.commands;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;
import fr.ulity.core.bukkit.utils.permissions;

public class importlangCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
    	
    	if ((!sender.getName().equals("360matt")) || (!permissions.hasPrivileges(sender))) {
    		sender.sendMessage("§7Cette commande est réservée au créateur du plugin, §b360matt§7, elle permet de faciliter l'importation des fichiers de langues");
    		return true;
    	}
    	sender.sendMessage("§7GG tu es entré dans cet endroit secret §e☺");
    	
    	if (args.length != 1) {
    		sender.sendMessage("§cOoops :/ §7la bonne §csyntaxe §7est: §c/importlang <iso> §e☺");
    		return true;
    	}
    		
    	
    	File importF = new File(mainBukkit.plugin.getDataFolder() + "/language/", args[0] + ".yml");
    	
    	if (!importF.exists()) {
    		sender.sendMessage("§cLe fichier de langue §7" + args[0] + ".yml §cexiste pas");
    		return true;
    	}
    	
    	YamlConfiguration importC = YamlConfiguration.loadConfiguration(importF);
    	
    	Reader langRefF = new InputStreamReader(lang.class.getResourceAsStream("language.yml"));
    	YamlConfiguration langRefC = YamlConfiguration.loadConfiguration(langRefF);
    	
    	
    	File outputimportF = new File(mainBukkit.plugin.getDataFolder() + "/language/", args[0] + "_added.yml");
    	
    	if (outputimportF.exists()) {
    		outputimportF.delete();
    		try {
				outputimportF.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	YamlConfiguration outputimportC = YamlConfiguration.loadConfiguration(outputimportF);

    	
    	
    	for (String x: langRefC.getKeys(true)) {
    		outputimportC.set(x, langRefC.get(x));
    	}
    	
    	for (String x: importC.getKeys(true)) {
    		boolean dontAdd = false;
        	for (String y: importC.getKeys(true)) {
        		if (y.contains(x) && !x.equals(y))
        			dontAdd = true;
        	}
    		
        	if (!dontAdd)
        		outputimportC.set(x + "." + args[0], importC.get(x));
    	}

    	outputimportC.set("lang." + args[0], "Hey");
    	
    	try {
			outputimportC.save(outputimportF);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	sender.sendMessage("§7Fichier final: §c/language/" + args[0] + "_added.yml");
    	
		return true;
   }
}