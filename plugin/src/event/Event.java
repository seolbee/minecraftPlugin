package event;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import main.Main;

public class Event implements Listener{
	
	public static Main plugin;
	public HashMap<UUID, String> map = plugin.getMap();
	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		UUID uid = e.getPlayer().getUniqueId();
		
		if(!map.containsKey(uid)) {
			map.put(uid, e.getPlayer().getName());
		}
		
		Player p = e.getPlayer();
		
		p.sendMessage(p.getName()+"님이 입장하셨습니다.");
	}
	
	@EventHandler
	public void rightClick(PlayerInteractEvent e) {
		if(e.getAction() == Action.RIGHT_CLICK_AIR) {
			if(e.getPlayer().getItemInHand().getType() == Material.IRON_INGOT) {
				e.getPlayer().sendMessage("스킬 사용");
			}
		}
	}
}
