package fr.ulity.core.bukkit;

import java.io.File;

import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

@SuppressWarnings("unused")
public class Temp {
	public static YamlConfiguration tempC;
	
	public static boolean reload() {
		try {
			File tempF = new File(MainBukkit.plugin.getDataFolder(), "temp.yml");
			tempC = YamlConfiguration.loadConfiguration(tempF);
		    	
			System.out.println("§bUlity§7: §eFichier temporaire rechargé");
			return true;
		}
		catch (Exception e) {
			System.out.println("§bUlity§c: ERREUR: impossible de charger le fichier temporaire !");
			return false;
		}
    }

	private static boolean init () {
		if (tempC == null)
			reload();
		if (tempC == null)
			return false;
		return true;
	}
	
	public static String getString (String key) {
		if (!init())
			return "";
		return tempC.getString(key);
	}

	public static String getString(String key, @Nullable String value) {
		if (!init())
			return "";
		if (getString(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getString(key).replaceAll("&", "§");
	}

	public static int getInt(String key, @Nullable int value) {
		if (!init())
			return 0;
		if (tempC.get(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getInt(key);
	}
	
	public static Object get (String key) {
		if (!init())
			return null;
		return tempC.get(key); 
	}

	public static String get(String key, Object value) {
		if (!init())
			return "";
		if (get(key) == null) 
			tempC.addDefault(key, value);
		
		return tempC.getString(key).replaceAll("&", "§");
	}

	public static boolean isSet (String key) {
		if (!init())
			return false;
		if (tempC.isSet(key))
			return true;
		else
			return false;
	}

	public static void set (String key, Object value) { 
		if (!init())
			return;
		tempC.set(key, value); 
	}

	public static void delete (String key) { 
		if (!init())
			return;
		tempC.set(key, null); 
	}

	public static void deleteList (String key) {
		if (!init())
			return;

		for(String x : tempC.getKeys(true)){
		    if (x.contains(key)) {
		    	tempC.set(x, null);
		    }
		}
		
		tempC.set(key, null);
	}
	

}
