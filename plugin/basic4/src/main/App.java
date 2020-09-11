package main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin{
	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable() {
		console.sendMessage("서버 작동 시작");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(command.getName());
		if(command.getName().equals("hello")) {
			sender.sendMessage(sender.getName() + "님이 인사합니다.");
		}
		return true;
	}
	
	@Override
	public void onDisable() {
		console.sendMessage("서버 작동 중지");
	}
}
