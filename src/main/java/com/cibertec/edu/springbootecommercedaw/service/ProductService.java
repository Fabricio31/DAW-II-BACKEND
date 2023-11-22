package com.cibertec.edu.springbootecommercedaw.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.edu.springbootecommercedaw.model.Product;
import com.cibertec.edu.springbootecommercedaw.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//Metodo Listar
	public List<Product>listarProductos(){
		return productRepository.findAll();
	}
	//Metodo Registrar
	public void registrarProductos(Product product){
		productRepository.save(product);
	}
	//Metodo Eliminar
	public void eliminarProducto(Long id_product){
		productRepository.deleteById(id_product);
	}

}
