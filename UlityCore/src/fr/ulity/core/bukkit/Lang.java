package fr.ulity.core.bukkit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.YamlConfiguration;

import fr.ulity.core.bukkit.Config;
import fr.ulity.core.bukkit.MainBukkit;

public class Lang {
	public static YamlConfiguration langC;
	public static File langF;
	static Config config = new Config();

	public static void reload() {
		File langDir = new File(MainBukkit.plugin.getDataFolder() + "/language/");
		if (!langDir.exists())
			langDir.mkdir();

		langF = new File(MainBukkit.plugin.getDataFolder() + "/language/", Config.lang + ".yml");

		if (!langF.exists())
			try {
				langF.createNewFile();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		
		langC = YamlConfiguration.loadConfiguration(langF);
		
		Reader langRefF = null;
		
		try {
            langRefF = new InputStreamReader(Lang.class.getResourceAsStream("language.yml"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("§bUlity§c: erreur: unable to read language file into Jar ! §8(FR)");
            System.out.println("§bUlity§c: erreur: impossible de lire le fichier de langue dans le Jar ! §8(FR)");
            return;
        }
		
		YamlConfiguration langRefC = YamlConfiguration.loadConfiguration(langRefF);
		
	    for(String key : langRefC.getKeys(true)){
	        if (key.contains("." + Config.lang)) {
	        	if (!key.equals("lang." + Config.lang))
	        		langC.set(key.replaceAll("." + Config.lang, ""), langRefC.getString(key));
	        }
	    }
	    
		save();
		
	}
	
	
	public static boolean isInitialized () {
		if (langC == null)
			reload();
		if (langC == null) // again
			return false;
		return true;
	}
	
	public static void save () {
		try {
			langC.save(langF);
			System.out.println("§bUlity§7: §eFichier de langue sauvegardé");
		} 
		catch (IOException e) {
			System.out.println(e);
			System.out.println("§bUlity§c: error: unable to save the language file ! §8(EN)");
			System.out.println("§bUlity§c: erreur: impossible de sauvegarder le fichier de langue ! §8(FR)");
		}
	}

	@SuppressWarnings("static-access")
	public static void importFromFile (InputStream langToImport) {
		if (!isInitialized())
			return;
		
		Reader langToImportF = new InputStreamReader(langToImport);
		YamlConfiguration langToImportC;
		
		try {
			langToImportC = YamlConfiguration.loadConfiguration(langToImportF);
		}
		catch(IllegalArgumentException e) {
			e.printStackTrace();
			return;
		}
		
		for (String x: langToImportC.getKeys(true)) {
			if (x.contains("." + config.lang))
				langC.set(x.replaceAll("." + config.lang, ""), langToImportC.getString(x));
		}
		
		save();
		
	}

	public static String get (String key) {
		if (!isInitialized())
			return "";
		if (langC.isSet(key))
			return langC.getString(key).replaceAll("&", "§").replaceAll("§§", "&");
		else
			return "";
	}

	public static String get(String key, Object value) {
		if (!isInitialized())
			return "";
		if (!langC.isSet(key))
			langC.set(key, value);
		try {
			langC.save(langF);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return get(key);
	}

	public static boolean isSet (String key) {
		if (!isInitialized())
			return false;
		if (langC.isSet(key))
			return true;
		else
			return false;
	}

	public static void set (String key, String value) {
		if (!isInitialized())
			return;
		langC.set(key, value); 
		try {
			langC.save(langF);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void change (String iso) {
		config.set("lang", iso);
		reload();
	}
	
}
