package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.Accesories;

//Añadir soporte para CrossOrigin, eliminando CrossOrigin xq se añadio al paquete config y propierties
    //@CrossOrigin("http://localhost:4200")
//Probar cambiar nombre URL de api
@RepositoryRestResource(collectionResourceRel = "accesories", path="accesories")
public interface AccesoriesRepository extends JpaRepository<Accesories, Long> {

}
