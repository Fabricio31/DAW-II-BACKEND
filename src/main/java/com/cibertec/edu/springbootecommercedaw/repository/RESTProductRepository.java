package com.cibertec.edu.springbootecommercedaw.repository;

import com.cibertec.edu.springbootecommercedaw.model.ProductosApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "productos", path="rest-productos")
public interface RESTProductRepository extends JpaRepository<ProductosApi, Long> {



}
