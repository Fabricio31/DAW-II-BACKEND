package com.cibertec.edu.springbootecommercedaw.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="companies")
@Getter
@Setter
public class Companies {
	
	@Id
	@Column(name = "id_company")
	private Long id_company;
	
	@Column(name="name")
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "companies")
	private Set<Accesories> accesories;
	
	

}
