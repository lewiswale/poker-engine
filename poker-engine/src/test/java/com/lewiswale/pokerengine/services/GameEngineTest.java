package com.lewiswale.pokerengine.services;

import com.lewiswale.pokerengine.model.Card;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

@ExtendWith(SpringExtension.class)
public class GameEngineTest {
    private final int DECK_SIZE = 52;

    private GameEngine gameEngine;

    @BeforeEach
    public void setUp() {
        gameEngine = new GameEngine();
    }

    @Test
    public void testDeckInit() {
        List<Card> deck = gameEngine.getDeck();
        deck.forEach(System.out::println);
        assertThat(gameEngine.getDeck().size()).isEqualTo(DECK_SIZE);
    }

    @Test
    public void testShuffleDeck() {
        List<Card> deck = gameEngine.getDeck();
        System.out.println("Before shuffling:");
        deck.forEach(System.out::println);
        System.out.println();
        assertThat(deck.size()).isEqualTo(DECK_SIZE);

        gameEngine.shuffleDeck();
        deck = gameEngine.getDeck();
        System.out.println("After shuffling:");
        deck.forEach(System.out::println);
        assertThat(deck.size()).isEqualTo(DECK_SIZE);

        int count = 0;
        for (int i = 0; i < deck.size(); i++) {
            Card cardToCheck = deck.get(i);
            for (Card card : deck) {
                if (card.equals(cardToCheck)) {
                    count++;
                }
            }

            if (count > 1) {
                fail("Duplicates found in deck.");
            } else {
                count = 0;
            }
        }
    }
}