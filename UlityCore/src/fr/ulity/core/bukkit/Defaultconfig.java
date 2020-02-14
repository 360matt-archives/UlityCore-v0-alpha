package fr.ulity.core.bukkit;

import java.util.List;

import javax.annotation.Nullable;

import org.bukkit.configuration.file.FileConfiguration;

@SuppressWarnings("unused")
public class Defaultconfig {
	public static String dbHost;
	public static String dbName;
	public static String dbUser;
	public static String dbPassword;
	public static boolean dbSSL;
	public static String lang;
	public static List<?> WorldProtect;

	
	public static void isAConfig() {
		try {
			Config Dconfig = new Config();

			lang = MainBukkit.config.getString("lang", "fr");

		}
		catch (Exception e) { }
    }


}
