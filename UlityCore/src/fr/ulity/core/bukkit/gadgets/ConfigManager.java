package fr.ulity.core.bukkit.gadgets;

import java.util.ArrayList;
import java.util.List;


import fr.ulity.core.bukkit.Config;

public class ConfigManager {
	static List<Config> configs = new ArrayList<>();

	public static void register (Config config) {
		configs.add(config);
	}
	
	public static void reloadAll () {
		try {
			for (int i = configs.size() - 1 ; i >= 0 ; i--) {
				configs.get(i).reload();
			}
		}
		catch(Exception e) {}

	}
	
}
