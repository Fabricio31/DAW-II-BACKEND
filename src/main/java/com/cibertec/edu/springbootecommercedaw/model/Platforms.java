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
@Table(name="platforms")
@Getter
@Setter
public class Platforms {

	@Id
	@Column(name = "id_platforms")
	private Long id_platforms;
	
	@Column(name="plataform_name")
	private String plataform_name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "platforms")
	private Set<Games> games;
}
