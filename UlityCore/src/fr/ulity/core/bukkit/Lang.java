package fr.ulity.core.bukkit;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.bukkit.configuration.file.YamlConfiguration;

public class Lang {
	public static YamlConfiguration langC;
	public static File langF;
	static Config config = new Config();

	public static boolean reload() {

		File langDir = new File(MainBukkit.plugin.getDataFolder() + "/language/");
		if (!langDir.exists())
			langDir.mkdir();

		langF = new File(MainBukkit.plugin.getDataFolder() + "/language/", Config.lang + ".yml");


		if (!langF.exists()) {
			Reader langRefF = null;

			try {
	            langRefF = new InputStreamReader(Lang.class.getResourceAsStream("language.yml"));
	        } catch (Exception e) {
	            e.printStackTrace();
	            System.out.println("§bUlity§c: ERREUR: impossible de lire le fichier de langue dans le Jar !");
	        }

			YamlConfiguration langRefC = YamlConfiguration.loadConfiguration(langRefF);

			// lecture du fichier de langue de référence

			String iso;
			if (langRefC.isSet("lang." + Config.lang))
				iso = Config.lang;
			else
				iso = "fr";
			
			langF = new File(MainBukkit.plugin.getDataFolder() + "/language/", iso + ".yml");
			langDir = new File(MainBukkit.plugin.getDataFolder() + "/language/");

			try {
				if (!langF.exists())
					langF.createNewFile();

			}
			catch (Exception e) {
				System.out.println(e);
				System.out.println("§bUlity§c: ERREUR: impossible de créer le fichier de langue !");
				return false;
			}

			langC = YamlConfiguration.loadConfiguration(langF);

		    for(String key : langRefC.getKeys(true)){
		        if (key.contains("." + iso)) {
		        	if (!key.equals("lang." + iso))
		        		get(key.replaceAll("." + iso, ""), langRefC.getString(key));
		        }
		    }

			try {
				langC.save(langF);
				System.out.println("§bUlity§7: §eFichier de langue sauvegardé");
			} 
			catch (IOException e) {
				System.out.println(e);
				System.out.println("§bUlity§c: ERREUR: impossible de sauvegarder le fichier de langue !");
			}

		}
		else {
			langC = YamlConfiguration.loadConfiguration(langF);
			System.out.println("§bUlity§7: §eFichier de langue sauvegardé");
		}
						
		return true;
    }

	
	
	@SuppressWarnings("static-access")
	public static void importFromFile (InputStream langToImport) {
		if (langC == null)
			reload();
		if (langC == null)
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
				get(x.replaceAll("." + config.lang, ""), langToImportC.getString(x));
		}
		
	}
	

	public static String get (String key) {
		if (langC == null)
			reload();
		if (langC == null)
			return "";
		if (langC.isSet(key))
			return langC.getString(key).replaceAll("&", "§").replaceAll("§§", "&");
		else
			return "";
	}

	public static String get(String key, Object value) {
		if (langC == null)
			reload();
		if (langC == null)
			return "";
		if (!langC.isSet(key))
			langC.set(key, value);
		
		return get(key);
	}

	public static boolean isSet (String key) {
		if (langC == null)
			reload();
		if (langC == null)
			return false;
		if (langC.isSet(key))
			return true;
		else
			return false;
	}

	public static void set (String key, String value) {
		if (langC == null)
			reload();
		if (langC == null)
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
