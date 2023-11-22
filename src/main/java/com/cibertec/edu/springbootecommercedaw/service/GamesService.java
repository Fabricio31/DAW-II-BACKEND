package com.cibertec.edu.springbootecommercedaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.repository.GamesRepository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;
	
	public List<Games> listarJuegos(){
		return gamesRepository.findAll();
	}
	
	public void registrarJuegos(Games games) {
		gamesRepository.save(games);
	}
	
	public void eliminarJuegos(Long id_game) {
		gamesRepository.deleteById(id_game);
	}
	

}
