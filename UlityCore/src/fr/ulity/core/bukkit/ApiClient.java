package fr.ulity.core.bukkit;

import javax.annotation.Nullable;

import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class ApiClient {
	static Plugin plugin;
	static Api apiClass;
	private static fr.ulity.core.bukkit.Lang lang;
	private static fr.ulity.core.utils.IndexUtils utils;
	private static fr.ulity.core.bukkit.animations.IndexAnimations animations;
	private static fr.ulity.core.bukkit.utils.Permissions permissions;
	private static fr.ulity.core.bukkit.Temp temp;
	private static fr.ulity.core.bukkit.Config config;

	static {
		System.out.println("§cLoading API ... / Chargement de l'API");
	}
	
	static void initialize (Plugin _plugin) {
		if (!_plugin.getServer().getPluginManager().isPluginEnabled("UlityCore")) {
			_plugin.getPluginLoader().disablePlugin(_plugin);
			System.out.println("§cUlityCore is missing !!\nUlityCore est absent !!");
		}
		else {
			plugin = _plugin;
			apiClass = fr.ulity.core.bukkit.MainBukkit.api;
			lang = new fr.ulity.core.bukkit.Lang();
			utils = new fr.ulity.core.utils.IndexUtils();
			animations = new fr.ulity.core.bukkit.animations.IndexAnimations();
			permissions = new fr.ulity.core.bukkit.utils.Permissions();
			temp = new fr.ulity.core.bukkit.Temp();
		}
	}
	
	static boolean isInitialized () {
		if (plugin != null)
			return true;
		else {
			System.out.println("Oooh, error: API not initialized\nOooh, erreur: l'API n'a pas été initializée");
			return false;
		}
	}
	
	
	public static fr.ulity.core.bukkit.Config config (@Nullable String name) {
		if (!isInitialized()) 
			return null;
		if (name == null) 
			return new fr.ulity.core.bukkit.Config();
		else 
			return new fr.ulity.core.bukkit.Config(name);
	}
	
}
 