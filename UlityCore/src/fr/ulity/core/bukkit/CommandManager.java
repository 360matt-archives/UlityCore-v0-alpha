package fr.ulity.core.bukkit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.ulity.core.utils.Syntax;

public class CommandManager {
	
	private static Config CommandConf = null;
	String CommandName;
	String PluginName;

	public CommandManager() {
		reload();
	}
	
	public CommandManager (String _p, String _n) {
		if (CommandConf == null)
			reload();
		PluginName = _p;
		CommandName = _n;
	}
	
	public CommandManager(String _p) {
		if (CommandConf == null)
			reload();
		PluginName = _p;
	}
	
	public void reload() {
		CommandConf = new Config("language/" + Config.lang + "_commands");
		CommandConf.reload();
	}
	
	public String description (String Description) {
		if (CommandConf == null)
			reload();
		return CommandConf.getString(PluginName + "." + CommandName + ".description", Description);
	}
	
	public String syntax (String ...SyntaxCommand) {
		if (CommandConf == null)
			reload();
		return CommandConf.getString(PluginName + "." + CommandName + ".syntax", Syntax.runSimple(CommandName, SyntaxCommand));
	}
	
	public Map<String, String> getCommand (String Name) {
		if (CommandConf == null)
			reload();

		Map <String, String> hash = new HashMap<String, String>();
		hash.put("syntax", CommandConf.getString(PluginName + "." + Name + ".syntax"));
		hash.put("description", CommandConf.getString(PluginName + "." + Name + ".description"));
		
		return hash;
	}
	

	public ArrayList<Map<String, String>> getCommandsFromList (String CommandListName) {
		if (CommandConf == null)
			reload();
		
		ArrayList<Map <String, String>> cmd = new ArrayList<Map <String, String>>();
		
		for (String x: CommandConf.getSection(PluginName + "." + CommandListName).getKeys(false)) {
			if (!x.equals("syntax") && !x.equals("description")) {
				Map <String, String> hash = new HashMap<String, String>();
				hash.put("name", x);
				hash.put("syntax", CommandConf.getString(PluginName + "." + CommandListName + "." + x + ".syntax"));
				hash.put("description", CommandConf.getString(PluginName + "." + CommandListName + "." + x + ".description"));
				
				cmd.add(hash);
			}
		}
		
		return cmd;
	}

	
}
