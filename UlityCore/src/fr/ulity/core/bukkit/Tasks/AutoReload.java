package fr.ulity.core.bukkit.Tasks;

import org.bukkit.scheduler.BukkitScheduler;

import fr.ulity.core.bukkit.MainBukkit;
import fr.ulity.core.bukkit.gadgets.ConfigManager;

public class AutoReload {
		
	public static void run () {
		BukkitScheduler scheduler = MainBukkit.server.getScheduler();
	    scheduler.scheduleSyncRepeatingTask(MainBukkit.plugin, new Runnable() {
	        @Override
	        public void run() {
	            ConfigManager.reloadAll();
	        }
	    }, 0L, 10*60*20L);
	}
	    
	
	
}
