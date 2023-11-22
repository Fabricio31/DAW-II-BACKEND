package com.cibertec.edu.springbootecommercedaw.repository;

import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.RESTGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "restgames", path="rest-games")
public interface RESTGameRepository extends JpaRepository<RESTGames, Long> {

}
