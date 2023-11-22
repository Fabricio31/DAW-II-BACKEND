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
@Table(name="categories")
@Getter
@Setter
public class Categories {

	@Id
	@Column(name = "id_category")
	private Long id_category;
	
	@Column(name="name_category")
	private String name_category;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "categories")
	private Set<Games> games;
	
}
