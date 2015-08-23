package com.henry.minecraftgamebase.arena;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class SpawnPoint {

	Location location;

	public SpawnPoint(Location l) {
		this.location = l;
	}

	public void setSpawn(Player p) {
		p.setBedSpawnLocation(location, true);
	}

	public void teleportPlayer(Player p) {
		p.teleport(location);
	}

}
