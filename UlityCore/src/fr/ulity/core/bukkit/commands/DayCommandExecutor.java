package fr.ulity.core.bukkit.commands;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.ulity.core.bukkit.lang;
import fr.ulity.core.bukkit.mainBukkit;

public class DayCommandExecutor implements CommandExecutor {
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		World world;
    	
    	if (!(sender instanceof Player)) 
    		world = mainBukkit.server.getWorlds().get(0);
    	else {
    		Player player = (Player)sender;
    		world = player.getWorld();
    	}
    	
		if (args.length != 0) {
			if (args[0].equals("off") || args[0].equals("clear")) {
				world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, false);
				sender.sendMessage(lang.get("msg.TimeChanged").replaceAll("%time%", lang.get("day")).replaceAll("%world%", world.getName()));
			}
			else if (args[0].equals("on")){
				world.setGameRule(GameRule.DO_DAYLIGHT_CYCLE, true);
				sender.sendMessage(lang.get("msg.TimeChanged").replaceAll("%time%", lang.get("invariable")).replaceAll("%world%", world.getName()));
			}
			else 
				sender.sendMessage(lang.get("msg.TimeChanged").replaceAll("%time%", lang.get("day")).replaceAll("%world%", world.getName()));
		}
		else
			sender.sendMessage(lang.get("msg.TimeChanged").replaceAll("%time%", lang.get("day")).replaceAll("%world%", world.getName()));
			
    	world.setTime(6000);
    	
	return true;
   }
}