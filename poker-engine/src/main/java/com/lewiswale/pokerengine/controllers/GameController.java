package com.lewiswale.pokerengine.controllers;

import com.lewiswale.pokerengine.model.GameState;
import com.lewiswale.pokerengine.services.GameEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/api/game")
public class GameController {
    @Autowired
    private GameEngine gameEngine;

    @RequestMapping("/join-game")
    public ResponseEntity<GameState> joinGame() {
        return new ResponseEntity<GameState>(gameEngine.addPlayer(), HttpStatus.OK);
    }
}
