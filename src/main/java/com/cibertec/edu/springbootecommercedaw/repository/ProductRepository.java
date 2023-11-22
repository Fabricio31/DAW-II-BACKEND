package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.Product;

//Añadir soporte para CrossOrigin
//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "products", path="products")
public interface ProductRepository extends JpaRepository<Product, Long> {
	

	//Metodo Query que busca los id
	Page<Product> findByCategoryId(@Param("id")Long id,Pageable pageable);

	//Metodo Query que busca los nombres
	Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);
	
	
}
