package com.cibertec.edu.springbootecommercedaw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.State;

//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "states", path="states")
public interface StateRepository extends JpaRepository<State, Integer> {
	
	List<State> findByCountryCode(@Param("code") String code);

}
