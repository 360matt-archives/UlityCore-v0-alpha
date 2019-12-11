package fr.ulity.core.utils;

import fr.ulity.core.bukkit.Lang;

public class Syntax {

	public static String run (String command, String ...args) {
		String syntax = "§c" + Lang.get("syntax") + ": §8/" + command + "";
		
		for (String x : args) {
			x = Lang.get("type." + x);
			syntax = syntax.concat(" §c<§7" + x + "§c>");
		}
		
		return syntax;
		
	}
	
	
}
