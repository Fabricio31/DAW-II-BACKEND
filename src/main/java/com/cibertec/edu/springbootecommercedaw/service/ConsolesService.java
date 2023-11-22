package com.cibertec.edu.springbootecommercedaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.springbootecommercedaw.model.Consoles;
import com.cibertec.edu.springbootecommercedaw.repository.ConsolesRepository;

@Service
public class ConsolesService {
	
	@Autowired
	private ConsolesRepository consolesRepository;
	
	public List<Consoles> listarConsolas(){
		return consolesRepository.findAll();
	}
	
	public void registrarConsola(Consoles consola) {
		consolesRepository.save(consola);
	}
	
	public void eliminarConsola(Long id_console) {
		consolesRepository.deleteById(id_console);
	}

}
