package com.cibertec.edu.springbootecommercedaw.repository;

import com.cibertec.edu.springbootecommercedaw.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends
        JpaRepository<Rol, Integer> {

    Rol findByNomrol(String nombrerol);
}