package fr.ulity.core.bukkit;

import org.bukkit.configuration.ConfigurationSection;

import fr.ulity.core.utils.Syntax;

public class CommandManager {
	
	private static Config CommandConf = null;
	String CommandName;
	String PluginName;

	public CommandManager (String _p, String _n) {
		if (CommandConf == null)
			CommandConf = new Config("language/" + Config.lang + "_commands");
		PluginName = _p;
		CommandName = _n;
	}
	
	public CommandManager() {
		reload();
	}
	
	public void reload() {
		CommandConf = new Config("language/" + Config.lang + "_commands");
		CommandConf.reload();
	}
	
	public void description (String Description) {

		CommandConf.get(PluginName + "." + CommandName + ".description", Description);
	}
	
	public void syntax (String ...SyntaxCommand) {
		CommandConf.get(PluginName + "." + CommandName + ".syntax", Syntax.runSimple(CommandName, SyntaxCommand));
	}
	
	public ConfigurationSection getCommand (String CommandName) {
		return CommandConf.getSection(PluginName + "." + CommandName);
	}

	
}
