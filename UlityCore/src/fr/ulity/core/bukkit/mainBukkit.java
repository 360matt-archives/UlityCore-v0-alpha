package fr.ulity.core.bukkit;

import fr.ulity.core.bukkit.commands.*;
import fr.ulity.core.bukkit.events.protectTask;

import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;


public class mainBukkit extends JavaPlugin {
	public static mainBukkit plugin;
	public static Server server;

	
	public static void broadcastMessage (String msg) {
    	server.broadcastMessage(msg);
	}
	
	
	
	
	
    @Override
    public void onEnable(){
    	plugin = this;
    	server = this.getServer();

    	config.reload();
    	lang.reload();
    	temp.reload();
    	
    	getServer().getPluginManager().registerEvents(new protectTask(), this);
    	
    	getCommand("ulitycore").setExecutor(new ulityCoreCommandExecutor());
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
    	getCommand("importlang").setExecutor(new importlangCommandExecutor());
    	getCommand("protect").setExecutor(new ProtectCommandExecutor());
    	getCommand("heal").setExecutor(new healCommandExecutor());
    	
    	
    	

    	
    	
    }
    
    @Override
    public void onDisable(){
    	
    }

	
	
}
