package test.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import test.Event.Event;
import test.File.MFile;

public class Main extends JavaPlugin{
	
	public ConsoleCommandSender console = Bukkit.getConsoleSender();
	
	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		
		Event.setPlugin(this);
		MFile.setPluin(this);
		
		Event event = new Event();
		MFile mFile = new MFile();
		mFile.DataFolder();
		
		getServer().getPluginManager().registerEvents(event, this);
		mFile.makeFile(mFile.f);
		mFile.mapToFile(mFile.f, event.map);
		mFile.fileToMap(mFile.f, event.map);
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}
}
