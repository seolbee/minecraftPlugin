package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	private final File f = new File(getDataFolder(), "/data.txt");
	
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	HashMap<UUID, Integer> map = new HashMap<UUID, Integer>();
	
	
	public void makeFile(File f) {
		if(!f.exists() || !f.isFile()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mapToFile(File f, HashMap<UUID, Integer> map) {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				try {
					console.sendMessage(ChatColor.GREEN + "데이터를 저장했습니다.");
					FileWriter writer = new FileWriter(f, false);
					for(UUID uuid : map.keySet()) {
						writer.write(uuid.toString() + "|" + map.get(uuid) + "\n");
					}
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, 20 * 30, 20 * 30);
	}
	
	public void fileToMap(File f, HashMap<UUID, Integer> map ) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			String fileLine = null;
			while((fileLine = reader.readLine())!=null) {
				UUID uuid = UUID.fromString(fileLine.split("\\|")[0]);
				String str = fileLine.split("\\|")[1];
				
				map.put(uuid,  Integer.parseInt(str));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void onEnable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 활성화 중 입니다.]");
		getServer().getPluginManager().registerEvents(this, this);
		
//		saveConfig();
//		File cfile = new File(getDataFolder(), "config.yml");
//		if(cfile.length() == 0) {
//			getConfig().options().copyDefaults(true);
//			saveConfig();
//		}
		makeFile(f);
		mapToFile(f, map);
		fileToMap(f, map);
	}
	
	@Override
	public void onDisable() {
		console.sendMessage(ChatColor.AQUA + "[플러그인 비활성화 중 입니다.]");
	}
	
	@EventHandler
	public void join(PlayerJoinEvent e) {
		
//		UUID uuid = e.getPlayer().getUniqueId();
//		
//		if(map.containsKey(uuid)) {
//			map.put(uuid,  map.get(uuid) + 1);
//		} else {
//			map.put(uuid, 1);
//		}
//		
//		int count = map.get(uuid);
//		e.setJoinMessage(count + "입장했습니다!");
		
		String msg = this.getConfig().getString("접속 메시지");
		e.setJoinMessage(msg);
	}
	
	@EventHandler
	public void breackBlock(BlockBreakEvent e) {
		String msg1 = this.getConfig().getString("블록메시지.첫번째");
		String msg2 = this.getConfig().getString("블록메시지.두번째");
		e.getPlayer().sendMessage(msg1);
		e.getPlayer().sendMessage(msg2);

	}
}
