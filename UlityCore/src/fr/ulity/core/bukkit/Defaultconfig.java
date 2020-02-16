package fr.ulity.core.bukkit;

public class Defaultconfig {
	public static String lang;
	
	public static void isAConfig() {
		lang = MainBukkit.config.getString("lang", "fr");
    }


}
