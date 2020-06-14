package com.lewiswale.pokerengine.services;

import com.lewiswale.pokerengine.model.Card;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class GameEngine {
    private static final int DECK_SIZE = 52;

    private List<Card> deck;
    private Random r;

    public GameEngine() {
        initDeck();
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

    public List<Card> getHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(deck.get(0));
        hand.add(deck.get(1));

        return hand;
    }
}
