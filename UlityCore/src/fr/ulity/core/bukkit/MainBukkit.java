package fr.ulity.core.bukkit;

import fr.ulity.core.bukkit.Tasks.AutoReload;
import fr.ulity.core.bukkit.commands.*;
import fr.ulity.core.bukkit.events.Banned;
import fr.ulity.core.bukkit.events.ClearTemp;
import fr.ulity.core.bukkit.gadgets.ConfigManager;

import org.bukkit.Server;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class MainBukkit extends JavaPlugin {
	public static MainBukkit plugin ;
	public static Api api = new Api();
	public static Server server;
	public static Config config = new Config();
	public static PluginManager pMan;

	
	
    @Override
    public void onEnable(){
    	
    	plugin = this;
    	server = this.getServer();

    	Temp.reload();
    	config.reload();
    	
    	Lang.reload();
    	
    	
    	pMan = server.getPluginManager();
    	
    	for (Plugin x: pMan.getPlugins()) {
    		if (x.getDescription().getDepend().contains(plugin.getName())) {
    			if (x.isEnabled())
    				pMan.disablePlugin(x);
    			pMan.enablePlugin(x);
    		}
    	}
    	
    	AutoReload.run();
    	
    	pMan.registerEvents(new Banned(), this);
    	pMan.registerEvents(new ClearTemp(), this);
    	
    	getCommand("ulitycore").setExecutor(new UlityCoreCommandExecutor());
    	getCommand("clc").setExecutor(new ClcCommandExecutor());
    	getCommand("day").setExecutor(new DayCommandExecutor());
    	getCommand("night").setExecutor(new NightCommandExecutor());
    	getCommand("broadcast").setExecutor(new BroadcastCommandExecutor());
    	getCommand("fly").setExecutor(new FlyCommandExecutor());
    	getCommand("gamemode").setExecutor(new GamemodeCommandExecutor());
    	getCommand("gmc").setExecutor(new GmcCommandExecutor());
    	getCommand("gms").setExecutor(new GmsCommandExecutor());
    	getCommand("gmp").setExecutor(new GmpCommandExecutor());
    	getCommand("gma").setExecutor(new GmaCommandExecutor());
    	getCommand("importlang").setExecutor(new ImportlangCommandExecutor());
    	getCommand("heal").setExecutor(new HealCommandExecutor());
    	getCommand("ban").setExecutor(new BanCommandExecutor());
    	getCommand("unban").setExecutor(new UnbanCommandExecutor());
    	getCommand("tempban").setExecutor(new TempbanCommandExecutor());
    	getCommand("kick").setExecutor(new KickCommandExecutor());
    	

    	
    	
    }
    
    @Override
    public void onDisable(){
    	
    	Lang.reload();
    	ConfigManager.reloadAll();
    	
    	for (Plugin x: pMan.getPlugins()) {
    		if (x.getDescription().getDepend().contains(plugin.getName())) {
    			pMan.disablePlugin(x);
    		}
    	}
    	
    }

	
	
}
