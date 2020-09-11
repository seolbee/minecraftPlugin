package file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import main.Main;

public class FileSystem{
	public static Main plugin;
	
	public final File f = new File("/data.txt");

	public static void setPlugin(Main MainPlugin) {
		plugin = MainPlugin;
	}
	
	public void makeFile(File f) {
		if(!f.exists() || !f.isFile()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public void mapToFile(File f, HashMap<UUID, String> map) {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask(plugin, new Runnable() {
			@Override
			public void run() {
				try {
					plugin.console.sendMessage(ChatColor.GREEN + "데이터를 저장했습니다.");
					FileWriter writer = new FileWriter(f, false);
					for(UUID uuid : map.keySet()) {
						writer.write(uuid.toString() + "|" + map.get(uuid)+ "\n");
					}
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}, 20 * 30, 20 * 30);
	}
	
	public void fileToMap(File f, HashMap<UUID, String> map) {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(f));
			String fileLine = null;
			while((fileLine = reader.readLine()) != null) {
				UUID uuid = UUID.fromString(fileLine.split("\\|")[0]);
				String str = fileLine.split("\\|")[1];
				
				map.put(uuid, str);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
