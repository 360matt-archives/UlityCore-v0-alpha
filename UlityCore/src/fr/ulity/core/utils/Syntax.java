package fr.ulity.core.utils;

import fr.ulity.core.bukkit.lang;

public class syntax {

	public static String run (String command, String ...args) {
		String syntax = "§c" + lang.get("syntax") + ": §8/" + command + "";
		
		for (String x : args) {
			x = lang.get("type." + x);
			syntax = syntax.concat(" §c<§7" + x + "§c>");
		}
		
		return syntax;
		
	}
	
	
}
