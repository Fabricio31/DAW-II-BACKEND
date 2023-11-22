package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.cibertec.edu.springbootecommercedaw.model.Games;
//@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "games", path="games")
public interface GamesRepository extends JpaRepository<Games, Long> {

}
