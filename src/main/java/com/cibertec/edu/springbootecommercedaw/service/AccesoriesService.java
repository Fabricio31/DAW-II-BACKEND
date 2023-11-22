package com.cibertec.edu.springbootecommercedaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.springbootecommercedaw.model.Accesories;
import com.cibertec.edu.springbootecommercedaw.repository.AccesoriesRepository;


@Service
public class AccesoriesService {
	
	@Autowired
	private AccesoriesRepository accesoriesRepository;
	
	public List<Accesories> listarAccesorios(){
		return accesoriesRepository.findAll();
	}
	
	public void registrarAccesorios(Accesories accesorios) {
		accesoriesRepository.save(accesorios);
	}
	
	public void eliminarAccesorios(Long id_accessories) {
		accesoriesRepository.deleteById(id_accessories);
	}

}
