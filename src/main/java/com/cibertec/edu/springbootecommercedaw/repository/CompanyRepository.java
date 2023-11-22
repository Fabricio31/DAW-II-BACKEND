package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.Companies;

//Añadir soporte para CrossOrigin
//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "company", path="company")
public interface CompanyRepository extends JpaRepository<Companies, Long> {

}
