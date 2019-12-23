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
		    	
		    // config par défaut:
			
			/*
			dbHost = MainBukkit.config.getString("db.host", "127.0.0.1");
			dbName = MainBukkit.config.getString("db.name", "test");
			dbUser = MainBukkit.config.getString("db.user", "root");
			dbPassword = MainBukkit.config.getString("db.password", "secret");
			dbSSL = (boolean) MainBukkit.config.get("db.ssl", true);
			*/
				
			lang = MainBukkit.config.getString("lang", "fr");

		}
		catch (Exception e) { }
    }


}
