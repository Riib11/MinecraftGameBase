package com.henry.minecraftgamebase.arena.builder;

import com.henry.minecraftgamebase.arena.Arena;
import com.henry.minecraftgamebase.arena.Lobby;

public class ArenaBuilder {

	public static boolean setArenaCuboid(Arena a, Cuboid c) {
		a.setCuboid(c);
		return true;
	}

	public static boolean setLobbyCuboid(Arena a, Cuboid c) {
		if (a.getCuboid().containsCuboid(c)) {
			return false;
		}
		a.setLobby(new Lobby(c));
		return true;
	}

}
