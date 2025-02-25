package com.henry.minecraftgamebase.arena.players;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import com.henry.minecraftgamebase.Main;
import com.henry.minecraftgamebase.arena.Arena;

public class ArenaStatusMeta {

	public enum ArenaStatus {

		PREGAME_LOBBY_NOTREADY, PREGAME_LOBBY_READY, INGAME_ALIVE, INGAME_DEAD,

	}

	public enum Team {
		A, B, C, D, UNASSIGNED
	}

	public Arena arena;
	public ArenaStatus arenaStatus;
	public Team team;

	public ArenaStatusMeta(Arena a) {
		this.arena = a;
		this.arenaStatus = ArenaStatus.PREGAME_LOBBY_NOTREADY;
		this.team = Team.UNASSIGNED;
	}

	public ArenaStatusMeta(Arena a, ArenaStatus as, Team t) {
		this.arena = a;
		this.arenaStatus = as;
		this.team = t;
	}

	private static String key = "arenaStatusMetaKey";

	public static void setArenaStatus(Player p, Arena a, ArenaStatus as, Team t) {
		p.setMetadata(key, new FixedMetadataValue(Main.plugin,
				new ArenaStatusMeta(a, as, t)));
	}

	public static ArenaStatusMeta getArenaStatus(Player p) {
		if (p.hasMetadata(key)) {
			return (ArenaStatusMeta) p.getMetadata(key);
		} else {
			return null;
		}
	}

	public Arena getArena() {
		return arena;
	}

	public void setArena(Arena arena) {
		this.arena = arena;
	}

	public ArenaStatus getArenaStatus() {
		return arenaStatus;
	}

	public void setArenaStatus(ArenaStatus arenaStatus) {
		this.arenaStatus = arenaStatus;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

}
