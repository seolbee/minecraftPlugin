package command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import main.Main;

public class CCommand implements CommandExecutor{
	
	public static Main plugin;
	
	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;
	}
	
	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		
		return false;
	}
}
