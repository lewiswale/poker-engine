package com.lewiswale.pokerengine.controllers;

import com.lewiswale.pokerengine.model.Card;
import com.lewiswale.pokerengine.services.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private GameEngine gameEngine;

    @GetMapping("/get-hand")
    public List<Card> getHand() {
        gameEngine.shuffleDeck();
        return gameEngine.getHand();
    }
}
