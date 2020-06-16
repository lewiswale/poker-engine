package com.lewiswale.pokerengine.controllers;

import com.lewiswale.pokerengine.model.GameState;
import com.lewiswale.pokerengine.services.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/player")
public class PlayerController {
    @Autowired
    private GameEngine gameEngine;

    @GetMapping("/get-hand/{id}")
    public GameState getHand(@PathVariable Integer id) {
        return gameEngine.getHand(id);
    }
}
