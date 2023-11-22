package com.cibertec.edu.springbootecommercedaw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.edu.springbootecommercedaw.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	//Buscar en Customer x string email
    Customer findByEmail(String theEmail);

}
