package main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	@EventHandler
	public void join(PlayerJoinEvent j) {
		j.setJoinMessage(j.getPlayer().getName() + "님이 들어오셨습니다.");
	}
}	
