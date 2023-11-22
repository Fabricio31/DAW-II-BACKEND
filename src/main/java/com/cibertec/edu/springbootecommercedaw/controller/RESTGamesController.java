package com.cibertec.edu.springbootecommercedaw.controller;

import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.RESTGames;
import com.cibertec.edu.springbootecommercedaw.service.RESTGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rest-games")
@Controller
public class RESTGamesController {


    private RESTGameService restGameService;

    @GetMapping("")
    public ResponseEntity<List<RESTGames>> listarJuegos() {
        List<RESTGames> gamesList = new ArrayList<>();
        restGameService.listarJuegos().forEach(gamesList::add);
        if (gamesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gamesList, HttpStatus.OK);
    }


}
