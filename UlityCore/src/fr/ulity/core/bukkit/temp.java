package fr.ulity.core.bukkit;

import java.io.File;

import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

@SuppressWarnings("unused")
public class temp {
	public static YamlConfiguration tempC;
	
	

	
	public static boolean reload() {
		mainBukkit.plugin.saveDefaultConfig();
		try {
			
			mainBukkit.plugin.reloadConfig();
			
			File tempF = new File(mainBukkit.plugin.getDataFolder(), "temp.yml");

			tempC = YamlConfiguration.loadConfiguration(tempF);
		    	
			System.out.println("§bUlity§7: §eFichier temporaire rechargé");
				
			return true;
		}
		catch (Exception e) {
			System.out.println("§bUlity§c: ERREUR: impossible de charger le fichier temporaire !");
			return false;
		}
    }

	
	
	
	
	public static String getString (String key) {
		return tempC.getString(key);
	}

	public static String getString(String key, @Nullable String value) {
		if (tempC == null)
			reload();
		if (tempC == null)
			return "";
		if (getString(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getString(key).replaceAll("&", "§");
	}

	public static int getInt(String key, @Nullable int value) {
		if (tempC == null) 
			reload();
		if (tempC == null)
			return 0;
		if (tempC.get(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getInt(key);
	}
	
	public static Object get (String key) {
		return tempC.get(key); 
	}

	public static String get(String key, Object value) {
		if (tempC == null) 
			reload();
		if (tempC == null)
			return "";
		if (get(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getString(key).replaceAll("&", "§");
	}

	public static boolean isSet (String key) {
		if (tempC == null) 
			reload();
		if (tempC == null)
			return false;
		if (tempC.isSet(key))
			return true;
		else
			return false;
	}

	public static void set (String key, Object value) { 
		if (tempC == null) 
			reload();
		if (tempC == null)
			return;
		tempC.set(key, value); 
	}

	public static void delete (String key) { 
		if (tempC == null) 
			reload();
		if (tempC == null)
			return;
		tempC.set(key, null); 
	}

	public static void deleteList (String key) {

		for(String x : tempC.getKeys(true))
		{
		    if (x.contains(key)) {
		    	tempC.set(x, null);
		    }
		}
		
		tempC.set(key, null);
	}
	

}
