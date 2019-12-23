package fr.ulity.core.utils;

import fr.ulity.core.bukkit.Lang;

public class Syntax {

	@SuppressWarnings("static-access") // blc
	public static String run (String command, String ...args) {
		Lang _l = new Lang();
		String syntax = "§c" + _l.get("syntax") + ": §8/" + command + "";
		
		for (String x : args) {
			x = _l.get("type." + x);
			syntax = syntax.concat(" §c<§7" + x + "§c>");
		}
		
		return syntax;
		
	}
	
	@SuppressWarnings("static-access") // blc
	public static String runSimple (String command, String ...args) {
		Lang _l = new Lang();
		String syntax = "";
		
		for (String x : args) {
			x = _l.get("type." + x);
			syntax = syntax.concat("§c<§7" + x + "§c> ");
		}
		
		return syntax.trim();
		
	}
	

	
	
}
