package fr.ulity.core.bukkit;

import java.io.InputStream;

import javax.annotation.Nullable;

import org.bukkit.plugin.Plugin;

@SuppressWarnings("unused")
public class ApiClient {
	static Plugin plugin;
	static Api apiClass;
	static fr.ulity.core.bukkit.Lang lang;
	static fr.ulity.core.utils.IndexUtils utils;
	static fr.ulity.core.bukkit.animations.IndexAnimations animations;
	static fr.ulity.core.bukkit.utils.Permissions permissions;
	static fr.ulity.core.bukkit.Temp temp;
	static fr.ulity.core.bukkit.Config config;

	static {
		System.out.println("§eLoading API ... / Chargement de l'API");
	}
	
	static void initialize (Plugin _plugin) {
		if (!_plugin.getServer().getPluginManager().isPluginEnabled("UlityCore")) {
			_plugin.getPluginLoader().disablePlugin(_plugin);
			System.out.println("§c---> UlityCore is missing !!\n§c---> UlityCore est absent !!");
		}
		else {
			plugin = _plugin;
			apiClass = fr.ulity.core.bukkit.MainBukkit.api;
			lang = new fr.ulity.core.bukkit.Lang();
			utils = new fr.ulity.core.utils.IndexUtils();
			animations = new fr.ulity.core.bukkit.animations.IndexAnimations();
			permissions = new fr.ulity.core.bukkit.utils.Permissions();
			temp = new fr.ulity.core.bukkit.Temp();
			
			InputStream langToImport = null;
			
			try {
				langToImport = ApiClient.class.getResourceAsStream("language.yml");
			}
			catch (NullPointerException e) {
				e.printStackTrace();
			}
			
			if (langToImport != null) 
				lang.importFromFile(langToImport);
			
		}
	}
	
	static boolean isInitialized () {
		if (plugin != null)
			return true;
		else {
			System.out.println("§c---> Oooh, error: API not initialized\n§c---> Oooh, erreur: l'API n'a pas été initializée");
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
 