package com.henry.minecraftgamebase.arena;

import org.bukkit.entity.Player;

public class ArenaManager {

	Arena arena;

	public ArenaManager(Arena a) {
		this.arena = a;
	}

	public void toggleArenaActive() {
		arena.setActive(!arena.isActive());
	}

	public void toggleArenaActive(boolean b) {
		arena.setActive(b);
	}

	public void joinPlayer(Player p) {

	}

	public void leavePlayer(Player p) {

	}

	public void votePlayer(Player p) {

	}

	public void startGame() {
		arena.setPlaying(true);
		distributePlayers();
	}

	private void distributePlayers() {

	}

	public void containPlayersInBounds() {

	}

	public void respawnPlayer(Player p) {

	}

	public void endGame() {
		arena.setPlaying(false);
	}

}
