package com.cibertec.edu.springbootecommercedaw.service;


import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.RESTGames;
import com.cibertec.edu.springbootecommercedaw.repository.GamesRepository;
import com.cibertec.edu.springbootecommercedaw.repository.RESTGameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RESTGameService {

    private RESTGameRepository restGameRepository;

    //Metodo Listar
    public List<RESTGames> listarJuegos() {
        return restGameRepository.findAll();
    }

    //Metodo guardar/actualizar
    public RESTGames guardar(RESTGames games) {
        return restGameRepository.save(games);
    }

    //Metodo basico buscar x ID
    public RESTGames obtenerJuegoPorId(Long id){
        return restGameRepository.findById(id).get();
    }


}
