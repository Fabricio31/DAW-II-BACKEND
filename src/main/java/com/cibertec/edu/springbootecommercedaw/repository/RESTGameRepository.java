package com.cibertec.edu.springbootecommercedaw.repository;

import com.cibertec.edu.springbootecommercedaw.model.Games;
import com.cibertec.edu.springbootecommercedaw.model.RESTGames;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(collectionResourceRel = "1", path="rest-games")
public interface RESTGameRepository extends JpaRepository<RESTGames, Long> {

    // collectionResourceRel = nombre de api en el listado CONFIRMADO
    // path = nombre en el controlador ??? cambie nombre de a rest-games-xd y controller se quedo con mismo nombre e igual mente
    //        mostro api listado ???


    //Realizando un cambio en la entidad RESTGames a Games (probar si solo necesita 1 entidad o 2)
    //Si funciono otra vez xd pero vamos a dejarlo con otra entidad para que no ocurran problemas

}
