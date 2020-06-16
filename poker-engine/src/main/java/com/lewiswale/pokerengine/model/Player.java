package com.lewiswale.pokerengine.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int id;
    private List<Card> playerHand;

    public Player(final int id) {
        this.id = id;
        this.playerHand = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public List<Card> getPlayerHand() {
        return playerHand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlayerHand(List<Card> playerHand) {
        this.playerHand = playerHand;
    }
}
