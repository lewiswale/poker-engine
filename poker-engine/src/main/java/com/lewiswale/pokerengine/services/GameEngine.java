package com.lewiswale.pokerengine.services;

import com.lewiswale.pokerengine.model.Card;
import com.lewiswale.pokerengine.model.GameState;
import com.lewiswale.pokerengine.model.Player;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameEngine {
    private static final int DECK_SIZE = 52;
    private static final int MAX_PLAYER_COUNT = 8;

    private List<Card> deck;
    private List<Player> players;
    private Random r;
    private int deckPosition = 0;

    public GameEngine() {
        players = new ArrayList<>();
        initDeck();
        shuffleDeck();
    }

    private void initDeck() {
        deck = new ArrayList<>();

        for (int i = 2; i < 15; i++) {
            for (int j = 0; j < 4; j++) {
                switch (j) {
                    case 0:
                        deck.add(new Card(i, 'S'));
                        break;
                    case 1:
                        deck.add(new Card(i, 'C'));
                        break;
                    case 2:
                        deck.add(new Card(i, 'H'));
                        break;
                    case 3:
                        deck.add(new Card(i, 'D'));
                        break;
                }
            }
        }
    }

    public void shuffleDeck() {
        List<Card> shuffledDeck = new ArrayList<>();
        r = new Random();

        for (int i = 0; i < DECK_SIZE; i++) {
            int nextCard = r.nextInt(deck.size());
            shuffledDeck.add(deck.get(nextCard));
            deck.remove(nextCard);
        }

        deck = shuffledDeck;
    }

    public List<Card> getDeck() {
        return deck;
    }

    public Card drawCard() {
        if (deckPosition == DECK_SIZE) {
            shuffleDeck();
            deckPosition = 0;
        }

        Card toReturn = deck.get(deckPosition);
        deckPosition++;

        return toReturn;
    }

    public GameState getHand(int playerId) {
        Player player = players.get(playerId);
        player.setPlayerHand(new ArrayList<>());
        player.getPlayerHand().add(drawCard());
        player.getPlayerHand().add(drawCard());

        return new GameState(player, players.size());
    }

    public GameState addPlayer() {
        Player player = new Player(players.size());
        players.add(player);
        player.getPlayerHand().add(drawCard());
        player.getPlayerHand().add(drawCard());

        return new GameState(player, players.size());
    }
}
