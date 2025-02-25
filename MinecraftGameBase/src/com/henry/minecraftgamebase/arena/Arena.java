package com.henry.minecraftgamebase.arena;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.bukkit.entity.Player;

import com.henry.minecraftgamebase.arena.builder.Cuboid;
import com.henry.minecraftgamebase.utilities.ArenaInfoAccessor;

public class Arena {

	public enum ArenaType {

		ONE_TEAM, TWO_TEAMS, THREE_TEAMS, FOUR_TEAMS;

		private String name;
		int number;

		static {
			ONE_TEAM.name = "ONE_TEAM";
			TWO_TEAMS.name = "TWO_TEAMS";
			THREE_TEAMS.name = "THREE_TEAMS";
			FOUR_TEAMS.name = "FOUR_TEAMS";

			ONE_TEAM.number = 1;
			TWO_TEAMS.number = 2;
			THREE_TEAMS.number = 3;
			FOUR_TEAMS.number = 4;
		}

		public static ArenaType fromString(String s) {
			ArenaType at = null;
			if (s.equalsIgnoreCase(ONE_TEAM.name)) {
				at = ONE_TEAM;
			} else if (s.equalsIgnoreCase(TWO_TEAMS.name)) {
				at = TWO_TEAMS;
			} else if (s.equalsIgnoreCase(THREE_TEAMS.name)) {
				at = THREE_TEAMS;
			} else if (s.equalsIgnoreCase(FOUR_TEAMS.name)) {
				at = FOUR_TEAMS;
			}
			return at;
		}

		public String toString() {
			return this.name();
		}

		public int getNumber() {
			return this.number;
		}
	}

	public Arena(String name, String description, int maxPlayers, int votes, ArenaType at,
			Lobby lobby, Cuboid cuboid, SpawnPoint[] spawns)
			throws UnsupportedEncodingException {
		this.name = name;
		this.desciption = description;
		this.maxPlayers = maxPlayers;
		this.setPlayers(new ArrayList<Player>());
		this.lobby = lobby;
		// spawns
		this.initializeArenaForType();

	}

	private String name;
	private String desciption;
	private int maxPlayers;
	private int votes;

	private Lobby lobby;

	private SpawnPoint[] spawns;
	private Cuboid cuboid;

	@SuppressWarnings("unused")
	private boolean complete = false;

	private ArenaType arenaType;

	private boolean isActive = false;
	private boolean isPlaying = false;

	private ArrayList<Player> players;

	public String getDesciption() {
		return desciption;
	}

	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setPlayers(ArrayList<Player> players) {
		this.players = players;
	}

	public void addPlayer(Player p) {
		this.players.add(p);
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isPlaying() {
		return isPlaying;
	}

	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}

	public ArenaType getArenaType() {
		return arenaType;
	}

	public void setArenaType(ArenaType arenaType) {
		this.arenaType = arenaType;
	}

	public boolean checkIfComplete() {
		if (lobby == null || !lobby.checkIfComplete()) {
			return false;
		}
		for (SpawnPoint sp : spawns) {
			if (sp == null) {
				return false;
			}
		}

		return true;
	}

	public void initializeArenaForType() {
		this.spawns = new SpawnPoint[this.arenaType.getNumber()];
	}

	public SpawnPoint[] getSpawns() {
		return spawns;
	}

	public void setSpawns(SpawnPoint[] spawns) {
		this.spawns = spawns;
	}

	public Cuboid getCuboid() {
		return cuboid;
	}

	public void setCuboid(Cuboid cuboid) {
		this.cuboid = cuboid;
	}

	public void saveToArenaInfo() {
		ArenaInfoAccessor.saveToArenaInfo(this);
	}

	public Lobby getLobby() {
		return lobby;
	}

	public void setLobby(Lobby lobby) {
		this.lobby = lobby;
	}

	public ArrayList<String> getPlayersAsString() {
		ArrayList<String> al = new ArrayList<String>();
		for (Player p : players) {
			al.add(p.getName());
		}
		return al;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
}
