package com.cibertec.edu.springbootecommercedaw.controller;

import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.RESTGames;
import com.cibertec.edu.springbootecommercedaw.service.RESTGameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/rest-games")
@Controller
public class RESTGamesController {


    // RECORDAR QUE METODOS CREATE PUT DELETE ESTAN DESHABILITADOS

    private RESTGameService restGameService;

    //Metodo Listar
    @GetMapping("")
    public ResponseEntity<List<RESTGames>> listarJuegos() {
        List<RESTGames> gamesList = new ArrayList<>();
        restGameService.listarJuegos().forEach(gamesList::add);
        if (gamesList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(gamesList, HttpStatus.OK);
    }


    //Metodo Buscar Por Id
    @GetMapping("{id}")
    public ResponseEntity<RESTGames>obtenerJuego(@PathVariable("id")Long id){
        RESTGames restGames = restGameService.obtenerJuegoPorId(id);
        return new ResponseEntity<>(restGames, HttpStatus.OK);
    }




    //Metodo Guardar
    @PostMapping("")
    public ResponseEntity<RESTGames> registrarCategoria(
            @RequestBody RESTGames games
    ){
        return new ResponseEntity<>(
                restGameService.guardar(games), HttpStatus.CREATED
        );
    }












}
