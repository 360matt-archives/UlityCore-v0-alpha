package fr.ulity.core.bukkit;

import fr.ulity.core.bukkit.commands.*;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;


public class MainBukkit extends JavaPlugin {
	public static MainBukkit plugin ;
	public static Api api = new Api();
	public static Server server;
	public static Config config;

	
	
    @Override
    public void onEnable(){
    	
    	plugin = this;
    	server = this.getServer();
    	
    	config = new Config();
    	config.reload();
    	
    	Lang.reload();
    	Temp.reload();
    	
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
    	

    	
    	
    }
    
    @Override
    public void onDisable(){
    	
    }

	
	
}
