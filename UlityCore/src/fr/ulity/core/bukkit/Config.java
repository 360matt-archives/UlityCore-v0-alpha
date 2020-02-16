package fr.ulity.core.bukkit;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import fr.ulity.core.bukkit.gadgets.ConfigManager;

public class Config extends Defaultconfig{
	private File configF;
	public FileConfiguration configC;
	private String nameConf = "config";
	
	public Config (@Nullable String name){
		if (name != null)
			nameConf = name;
	}
	
	public Config (){ }
	
	public boolean reload() {
		boolean canRegister = true;
		
		if (configC != null) {
			try {
				configC.save(configF);
			} catch (IOException e) {
				e.printStackTrace();
			};
		}
		else
			canRegister = true;
		
		configF = new File(MainBukkit.plugin.getDataFolder(), nameConf + ".yml");
			
		if (!configF.exists()) {
			try {
				configF.createNewFile();
			}
			catch(Exception e) {
				System.out.println("§bUlity§c: FR: ERREUR: impossible de créer le fichier de configuration §7" + nameConf);
				return false;
			}
				
		}
		
		configC = YamlConfiguration.loadConfiguration(configF);
		
		if (canRegister) 
			ConfigManager.register(this);


		
	if (nameConf.equals("config"))
		Config.isAConfig();
		System.out.println("§bUlity§7: §eFichier de configuration §7" + nameConf + " §erechargé");
				
		return true;
    }
	
	private boolean init () {
		if (configC == null)
			reload();
		if (configC == null)
			return false;
		return true;
	}

	
	public String getString (String key) {
		if (!init())
			return "";
		if (configC.isSet(key))
			return configC.getString(key);
		else
			return "";
	}

	public String getString(String key, @Nullable String value) {
		if (!init())
			return "";
		if (!configC.isSet(key)) 
			configC.set(key, value);

		return configC.getString(key).replaceAll("&", "§");
	}
	
	public List<?> getList (String key) {
		if (!init())
			return null;
		if (configC.isSet(key))
			return configC.getList(key);
		else
			return null;
	}

	public List<?> getList(String key, @Nullable Object[] exemple) {
		if (!init())
			return null;
		if (!configC.isSet(key)) 
			configC.set(key, exemple);

		return configC.getList(key);
	}
	
	public int getInt(String key) {
		if (!init())
			return 0;
		if (configC.isSet(key)) 
			return configC.getInt(key);
		else
			return 0;
	}

	public int getInt(String key, @Nullable int value) {
		if (!init())
			return 0;
		if (!configC.isSet(key)) 
			configC.set(key, value);
		return configC.getInt(key);
	}
	
	public boolean getBoolean(String key) {
		if (!init())
			return false;
		if (configC.isSet(key)) 
			return configC.getBoolean(key);
		return false;
	}

	public boolean getBoolean(String key, @Nullable boolean value) {
		if (!init())
			return false;
		if (!configC.isSet(key)) 
			configC.set(key, value);
		return configC.getBoolean(key);
	}
	
	public Object get (String key) {
		if (!init())
			return "";
		if (configC.isSet(key))
			return configC.get(key);
		else
			return null;
	}

	public Object get(String key, Object value) {
		if (!init())
			return "";
		if (!configC.isSet(key)) 
			configC.set(key, value);

		return configC.get(key);
	}

	public ConfigurationSection getSection (String key) {
		if (!init())
			return null;
		if (configC.isSet(key))
			return configC.getConfigurationSection(key);
		else
			return null;
	}

	public ConfigurationSection getSection(String key, @Nullable Map<?, ?> value) {
		if (!init())
			return null;
		if (!configC.isSet(key)) 
			configC.createSection(key, value);
	
		return configC.getConfigurationSection(key);
	}

	
	public boolean isSet (String key) {
		if (!init())
			return false;
		if (configC.isSet(key))
			return true;
		return false;
	}

	public void set (String key, Object value) { 
		if (!init())
			return;
		configC.set(key, value); 

	}


	public void delete (String key) { 
		if (!init())
			return;
		configC.set(key, null);

	}


	public void deleteAll (String key) { 
		if (!init())
			return;
		
		for (String i : configC.getKeys(true)) {
			if (i.contains(key))
				configC.set(key, null);
		}

	}


	
	

}
