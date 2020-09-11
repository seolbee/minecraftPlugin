package main;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import command.CCommand;
import event.Event;
import file.FileSystem;

public class Main extends JavaPlugin{
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	private HashMap<UUID, String> map = new HashMap<UUID, String>();
	
	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화]");
		
		Event.setPlugin(this);
		FileSystem.setPlugin(this);
		CCommand.setPlugin(this);
		
		Event event = new Event();
		FileSystem file = new FileSystem();
		
		file.makeFile(file.f);
		file.mapToFile(file.f, map);
		file.fileToMap(file.f, map);
	}
	
	public HashMap<UUID, String> getMap(){
		return map;
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.DARK_RED + "[플러그인 비활성화]");
	}
}
