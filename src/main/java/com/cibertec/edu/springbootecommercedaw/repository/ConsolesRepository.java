package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.Consoles;

//@CrossOrigin("http://localhost:4200")
@Repository
//Probar cambiar nombre de api
@RepositoryRestResource(collectionResourceRel = "console", path="console")
public interface ConsolesRepository extends JpaRepository<Consoles, Long> {

}
