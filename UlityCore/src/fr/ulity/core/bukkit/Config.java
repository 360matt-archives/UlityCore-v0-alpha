package fr.ulity.core.bukkit;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

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
		try {
			
			configF = new File(MainBukkit.plugin.getDataFolder(), nameConf + ".yml");
			
			if (!configF.exists())
				configF.createNewFile();
			
			configC = YamlConfiguration.loadConfiguration(configF);
			
			if (nameConf.equals("config"))
				Config.isAConfig();

			System.out.println("§bUlity§7: §eFichier de configuration §7" + nameConf + " §erechargé");
				
			return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("§bUlity§c: ERREUR: impossible de charger le fichier de configuration §7" + nameConf);
			return false;
		}
    }

	
	public String getString (String key) {
		if (configC == null)
			reload();
		if (configC == null)
			return "";
		if (configC.isSet(key))
			return configC.getString(key);
		else
			return "";
	}

	public String getString(String key, @Nullable String value) {
		if (configC == null)
			reload();
		if (configC == null)
			return "";
		if (!configC.isSet(key)) 
			configC.set(key, value);
		
		try {
			configC.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return configC.getString(key).replaceAll("&", "§");
	}
	
	public List<?> getList (String key) {
		if (configC == null)
			reload();
		if (configC == null)
			return null;
		if (configC.isSet(key))
			return configC.getList(key);
		else
			return null;
	}

	public List<?> getList(String key, @Nullable Object[] exemple) {
		if (configC == null)
			reload();
		if (configC == null)
			return null;
		if (!configC.isSet(key)) 
			configC.set(key, exemple);
		
		try {
			configC.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return configC.getList(key);
	}
	
	public int getInt(String key) {
		if (configC == null) 
			reload();
		if (configC == null)
			return 0;
		if (configC.isSet(key)) 
			return configC.getInt(key);
		else
			return 0;
	}

	public int getInt(String key, @Nullable int value) {
		if (configC == null) 
			reload();
		if (configC == null)
			return 0;
		if (!configC.isSet(key)) 
			configC.set(key, value);
		return configC.getInt(key);
	}
	
	public boolean getBoolean(String key) {
		if (configC == null) 
			reload();
		if (configC == null)
			return false;
		if (configC.isSet(key)) 
			return configC.getBoolean(key);
		return false;
	}

	public boolean getBoolean(String key, @Nullable boolean value) {
		if (configC == null) 
			reload();
		if (configC == null)
			return false;
		if (!configC.isSet(key)) 
			configC.set(key, value);
		return configC.getBoolean(key);
	}
	
	public Object get (String key) {
		if (configC.isSet(key))
			return configC.get(key);
		else
			return null;
	}

	public  Object get(String key, Object value) {
		if (configC == null) 
			reload();
		if (configC == null)
			return "";
		if (!configC.isSet(key)) 
			configC.set(key, value);
		
		try {
			configC.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return configC.get(key);
	}

	public ConfigurationSection getSection (String key) {
		if (configC == null) 
			reload();
		if (configC == null)
			return null;
		if (configC.isSet(key))
			return configC.getConfigurationSection(key);
		else
			return null;
	}

	public ConfigurationSection getSection(String key, @Nullable Map<?, ?> value) {
		if (configC == null) 
			reload();
		if (configC == null)
			return null;
		if (!configC.isSet(key)) 
			configC.createSection(key, value);
		
		try {
			configC.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		};
		
		return configC.getConfigurationSection(key);
	}

	
	public  boolean isSet (String key) {
		if (configC == null) 
			reload();
		if (configC == null)
			return false;
		if (configC.isSet(key))
			return true;
		return false;
	}

	public void set (String key, Object value) { 
		if (configC == null) 
			reload();
		if (configC == null)
			return;
		configC.set(key, value); 
		try {
			configC.save(configF);
		} catch (IOException e) {
			e.printStackTrace();
		};
	}


	
	
	

}
