package fr.ulity.core.bukkit;

import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings("unused")
public class config {
	public static FileConfiguration configF;
	public static String dbHost;
	public static String dbName;
	public static String dbUser;
	public static String dbPassword;
	public static boolean dbSSL;
	public static String lang;
	public static List<?> WorldProtect;
	
	

	
	public static boolean reload() {
		mainBukkit.plugin.saveDefaultConfig();
		try {
			
			mainBukkit.plugin.reloadConfig();

				configF = mainBukkit.plugin.getConfig();
		    	
		    	// config par défaut:
				
				dbHost = getString("db.host", "127.0.0.1");
				dbName = getString("db.name", "test");
				dbUser = getString("db.user", "root");
				dbPassword = getString("db.password", "secret");
				dbSSL = (boolean) get("db.ssl", true);
				
				lang = getString("lang", "fr");
				
				String[] exemple = { "world1", "monde2", "mundo3" };
				WorldProtect = getList("WorldProtect", exemple);


				
				mainBukkit.plugin.saveConfig();
				System.out.println("§bUlity§7: §eFichier de configuration rechargé");
				
				return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("§bUlity§c: ERREUR: impossible de charger le fichier de configuration !");
			return false;
		}
    }

	
	
	
	
	public static String getString (String key) {
		if (configF.isSet(key))
			return configF.getString(key);
		else
			return "";
	}

	public static String getString(String key, @Nullable String value) {
		if (configF == null)
			reload();
		if (configF == null)
			return "";
		if (!configF.isSet(key)) 
			configF.set(key, value);
		
		return configF.getString(key).replaceAll("&", "§");
	}
	
	public static List<?> getList (String key) {
		if (configF.isSet(key))
			return configF.getList(key);
		else
			return null;
	}

	public static List<?> getList(String key, @Nullable Object[] exemple) {
		if (configF == null)
			reload();
		if (configF == null)
			return null;
		if (!configF.isSet(key)) 
			configF.set(key, exemple);
		
		return configF.getList(key);
	}
	
	

	public static int getInt(String key, @Nullable int value) {
		if (configF == null) 
			reload();
		if (configF == null)
			return 0;
		if (!configF.isSet(key)) 
			configF.set(key, value);
		
		return configF.getInt(key);
	}
	
	public static Object get (String key) {
		if (configF.isSet(key))
			return configF.get(key);
		else
			return null;
	}

	public static Object get(String key, Object value) {
		if (configF == null) 
			reload();
		if (configF == null)
			return "";
		if (!configF.isSet(key)) 
			configF.set(key, value);
		
		return configF.get(key);
	}

	public static boolean isSet (String key) {
		if (configF == null) 
			reload();
		if (configF == null)
			return false;
		if (configF.isSet(key))
			return true;
		else
			return false;
	}

	public static void set (String key, String value) { 
		if (configF == null) 
			reload();
		if (configF == null)
			return;
		configF.set(key, value); 
		mainBukkit.plugin.saveConfig();
	}
	

}
