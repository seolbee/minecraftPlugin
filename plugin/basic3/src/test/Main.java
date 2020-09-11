package test;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	
	@Override
	public void onEnable() {
		System.out.println("Plugin is Activatied");
	}
	
	@Override
	public void onDisable() {
		System.out.println("Plugin is DisActivatied");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(command.getName().equalsIgnoreCase("t")) {
			if(args.length == 0) {
				sender.sendMessage(ChatColor.RED + "Type the command to execute");
			} else if(args[0].equalsIgnoreCase("info")) {
				sender.sendMessage(ChatColor.YELLOW + "This Plugin is Made By JSD-THAN");
			} else {
				sender.sendMessage(ChatColor.DARK_RED + "Command is not correct.");
			}
		}
		return true;
	}
}
