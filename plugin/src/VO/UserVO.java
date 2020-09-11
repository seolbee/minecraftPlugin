package VO;

import org.bukkit.entity.Player;

public class UserVO {
	private Player player;
	private SaikyVO saiky;
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public SaikyVO getSaiky() {
		return saiky;
	}
	
	public void setSaiky(SaikyVO saiky) {
		this.saiky = saiky;
	}
}
