package com.lewiswale.pokerengine.model;

public class GameState {
    private Player player;
    private int playerCount;

    public GameState(final Player player, final int playerCount) {
        this.player = player;
        this.playerCount = playerCount;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }
}
